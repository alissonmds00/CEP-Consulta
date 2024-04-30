package modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.API;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    List<CEP> listaCEPs = new ArrayList<>();
    FileWriter arquivoCEPs = new FileWriter("CEPs.json");
    Gson gson = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
    API api;

    String busca = "";

    private void consultarCEP() throws IOException, InterruptedException {

        System.out.println("""
                Digite o CEP que deseja consultar
                Ou "sair" para sair.""");
        try {
            busca = input.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Não reconhecemos o seu digito");
        }
        if (!busca.equalsIgnoreCase("sair")) {
            api = new API();
            if (api.init(busca) != null) {
                listaCEPs.add(api.init(busca));
            }
        }
    }

    private void cepsToJson() throws IOException {
        arquivoCEPs.write(gson.toJson(listaCEPs));
        arquivoCEPs.close();
    }

    public Menu() throws IOException {
    }

    public void init() throws IOException, InterruptedException {
        while (!busca.equalsIgnoreCase("sair")) {
            this.consultarCEP();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }
        }
        this.cepsToJson();
    }
}
