package Exception;

public class PacienteNaoEncontradoException extends RuntimeException {
    public PacienteNaoEncontradoException(String cpf) {
        super("Paciente com CPF '%s' não encontrado no cadastro.".formatted(cpf));
    }
}
