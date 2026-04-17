package Model;

public sealed interface EstadoAtendimento
        permits Triagem, Consulta, Exames, Finalizado {}