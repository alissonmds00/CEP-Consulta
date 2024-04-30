package modules;



public class CEP {
    String cep;
    String logradouro;
    String complemento;
    String bairro;
    String localidade;
    String uf;

    public CEP(CEPModel model) {
        this.cep = model.cep();
        this.logradouro = model.logradouro();
        this.complemento = model.complemento();
        this.bairro = model.bairro();
        this.localidade = model.localidade();
        this.uf = model.uf();
    }

    @Override
    public String toString() {
        return "CEP{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
