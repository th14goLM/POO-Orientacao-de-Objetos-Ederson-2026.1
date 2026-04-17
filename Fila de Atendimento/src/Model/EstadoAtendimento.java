package Model;

public sealed interface EstadoAtendimento
        permits Triagem, Consulta, Exames, Finalizado {}

record Triagem() implements EstadoAtendimento {}
record Consulta() implements EstadoAtendimento {}
record Exames() implements EstadoAtendimento {}
record Finalizado() implements EstadoAtendimento {}