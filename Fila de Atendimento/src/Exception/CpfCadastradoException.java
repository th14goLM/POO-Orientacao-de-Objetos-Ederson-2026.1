package Exception;

public class CpfCadastradoException extends RuntimeException {
    public CpfCadastradoException(String cpf) {
        super("Paciente com CPF '%s' já está cadastrado.".formatted(cpf));
    }
}