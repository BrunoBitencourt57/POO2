package excecoes;

public class GradeInvalidaException extends RuntimeException {

    public GradeInvalidaException(String mensagem) {
        super(mensagem);
    }

}