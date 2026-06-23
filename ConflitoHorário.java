// Quando tem conflito de horário
public class ConflitoHorarioException extends RuntimeException {
    public ConflitoHorarioException(String mensagem) {
        super(mensagem);
    }
}

// Para quando o professor não tem a competência
public class CompetenciaInvalidaException extends RuntimeException {
    public CompetenciaInvalidaException(String mensagem) {
        super(mensagem);
    }
}

