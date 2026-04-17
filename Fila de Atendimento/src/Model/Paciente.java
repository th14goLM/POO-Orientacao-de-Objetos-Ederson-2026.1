package Model;

import validationCPF.ValidaCPF;

public record Paciente(String nome, String cpf, String planoDeSaude) {

    public Paciente{
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do paciente é obrigatório.");
        }

        String cpfValidado = cpf.replaceAll("\\D", "");

        if (!ValidaCPF.CPF(cpfValidado)){
            throw new IllegalArgumentException("Cpf inválido: " + cpf);
        }
    }

    @Override
    public String toString() {
        return "Model.Paciente: %s | CPF: %s | Plano: %s".formatted(nome, validationCPF.ValidaCPF.imprimeCPF(cpf), planoDeSaude);
    }
}
