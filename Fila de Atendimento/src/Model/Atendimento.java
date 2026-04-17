package Model;

import java.time.LocalDateTime;

public record Atendimento(
        Paciente paciente,
        String senha,
        LocalDateTime horaChegada,
        boolean prioritario,
        EstadoAtendimento estado
){}