package Service;

import Model.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;

public class FluxoDeAtendimento {
    private final Map<String, Paciente> cadastros = new HashMap<>();

    public Atendimento novoPaciente(String nome, String cpf, String planoDeSaude, boolean prioritario){
        Paciente p = new Paciente(nome, cpf, planoDeSaude);
        cadastros.put(p.cpf(), p);

        return new Atendimento(
                p,
                "S-" + (System.currentTimeMillis() % 1000),
                LocalDateTime.now(),
                prioritario,
                new Triagem()
        );
    }

    public Atendimento avancar(Atendimento atual) {
        EstadoAtendimento proximo = switch (atual.estado()) {
            case Triagem _  -> new Consulta();
            case Consulta _ -> new Exames();
            case Exames _   -> new Finalizado();
            case Finalizado f -> f;
        };
        return new Atendimento(atual.paciente(), atual.senha(), atual.horaChegada(), atual.prioritario(), proximo);
    }
}