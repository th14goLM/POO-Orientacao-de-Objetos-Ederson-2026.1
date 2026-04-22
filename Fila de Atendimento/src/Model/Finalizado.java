package Model;

import java.time.LocalDateTime;

public record Finalizado(LocalDateTime finalizadoEm) implements EstadoAtendimento
{
    public Finalizado() {
        this(LocalDateTime.now());
    }
}