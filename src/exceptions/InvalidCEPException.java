package exceptions;

public class InvalidCEPException extends RuntimeException{
    String mensagem;

    public InvalidCEPException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMessage() {
        return this.mensagem;
    }
}
