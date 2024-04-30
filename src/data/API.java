package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modules.CEP;
import modules.CEPModel;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {

    public API() {
    }

    private String formatCEP(String cep) {
        return cep.replace("-", "");
    }


    public CEP init(String cep) throws IOException, InterruptedException {
        String api = "https://viacep.com.br/ws/%s/json/".formatted(cep);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(api))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
                .setPrettyPrinting()
                .create();
        CEPModel newCEPPattern;
        try {
            newCEPPattern = gson.fromJson(response.body(), CEPModel.class);
            if (newCEPPattern.cep() != null) {
                return new CEP(newCEPPattern);
            }
            System.out.println("Não foi possível consultar este CEP");
        } catch (Exception e) {
            System.out.println("Não foi possível consultar este CEP");
        }
        return null;
    }
}
