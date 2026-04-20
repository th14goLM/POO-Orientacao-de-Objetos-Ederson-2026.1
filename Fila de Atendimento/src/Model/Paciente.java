package Model;

import validationCPF.ValidaCPF;

public record Paciente(String nome, String cpf, String planoDeSaude, TipoPrioridade prioridade) {

    public Paciente {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("O nome do paciente é obrigatório.");

        String cpfValidado = cpf == null ? "" : cpf.replaceAll("\\D", "");

        if (!ValidaCPF.CPF(cpfValidado))
            throw new IllegalArgumentException("CPF inválido: " + cpf);

        if (planoDeSaude == null || planoDeSaude.isBlank())
            throw new IllegalArgumentException("O plano de saúde é obrigatório.");

        cpf = cpfValidado;
    }

    @Override
    public String toString() {
        return "Paciente: %s | CPF: %s | Plano: %s | Prioridade: %s".formatted(nome, validationCPF.ValidaCPF.imprimeCPF(cpf), planoDeSaude, prioridade);
    }
}
