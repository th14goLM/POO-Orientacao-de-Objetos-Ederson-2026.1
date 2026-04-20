package Model;

import java.time.LocalDateTime;

public record Atendimento(
        Paciente paciente,
        String senha,
        LocalDateTime horaChegada,
        TipoPrioridade prioridade,
        EstadoAtendimento estado
){
    public boolean prioritario() {
        return prioridade != TipoPrioridade.NORMAL;
    }

    @Override
    public String toString(){
        return "Atendimento{senha: '%s' | paciente: '%s' | prioritario: '%s'| estado: '%s'}"
                .formatted(senha, paciente.nome(), prioridade, estado.getClass().getSimpleName());
    }
}