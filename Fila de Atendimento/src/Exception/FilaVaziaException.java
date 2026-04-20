package Exception;

public class FilaVaziaException extends RuntimeException {
    public FilaVaziaException() {
        super("Não há pacientes na fila de atendimento.");
    }
}
