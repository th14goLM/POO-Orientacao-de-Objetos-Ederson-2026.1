package Service;

import Exception.CpfCadastradoException;
import Exception.PacienteNaoEncontradoException;
import Model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Aqui é onde o paciente passa por todos os atendimentos:
 * cadastro, etapas e registro do histórico.
 */
public class FluxoDeAtendimento {
    private final Map<String, Paciente> cadastros = new HashMap<>();
    private final List<Atendimento> historico = new ArrayList<>();
    private final AtomicInteger contador = new AtomicInteger(1);

/**
* Cadastra um novo paciente e cria o atendimento inicial na triagem.
* @throws  IllegalArgumentException  se nome, CPF ou plano forem inválidos
* @throws  CpfCadastradoException  se o CPF já estiver cadastrado
*/
    public Atendimento novoPaciente(String nome, String cpf, String planoDeSaude, TipoPrioridade prioridade) {
        String cpfLimpo = cpf == null ? "" : cpf.replaceAll("\\D", "");

        if (cadastros.containsKey(cpfLimpo)){
            throw new CpfCadastradoException(cpfLimpo);
        }

        Paciente paciente = new Paciente(nome, cpf, planoDeSaude, prioridade);
        cadastros.put(paciente.cpf(), paciente);

        String senha = "Senha-%03d".formatted(contador.getAndIncrement());

        return new Atendimento(
                paciente,
                senha,
                LocalDateTime.now(),
                null,
                prioridade,
                new Triagem()
        );
    }

    /**
     * Avança o atendimento para o próximo estado.
     * Retorna um novo record Atendimento (imutável) com o estado atualizado.
     * Quando já está em Finalizado, retorna o próprio atendimento sem alteração.
     */
    public Atendimento avancar(Atendimento atual) {
        EstadoAtendimento proximo = switch (atual.estado()) {
            case Triagem _  -> new Consulta();
            case Consulta _ -> new Exames();
            case Exames _   -> new Finalizado();
            case Finalizado f -> f;
        };
        return new Atendimento(
                atual.paciente(),
                atual.senha(),
                atual.horaChegada(),
                null,
                atual.prioridade(),
                proximo);
    }

    /**
     * Grava o atendimento finalizado no histórico.
     */
    public void registrarFinalizado(Atendimento atendimento) {
        if (!(atendimento.estado() instanceof Finalizado finalizado))
            throw new IllegalStateException(
                    "Só é possível registrar atendimentos finalizados. Estado atual: " +
                    atendimento.estado().getClass().getSimpleName());

        Atendimento comHoraSaida = new Atendimento(
                atendimento.paciente(),
                atendimento.senha(),
                atendimento.horaChegada(),
                LocalDateTime.now(),
                atendimento.prioridade(),
                finalizado
        );

        historico.add(comHoraSaida);
    }

    /**
     * Busca um paciente cadastrado pelo CPF.
     *
     * @throws PacienteNaoEncontradoException se o CPF não estiver no cadastro
     */
    public Paciente buscarPorCpf(String cpf) {
        String cpfLimpo = cpf == null ? "" : cpf.replaceAll("\\D", "");
        Paciente paciente = cadastros.get(cpfLimpo);

        if (paciente == null)
            throw new PacienteNaoEncontradoException(cpfLimpo);

        return paciente;
    }

    /**
     * Mostra uma lista de atendimentos finalizados.
     */
    public List<Atendimento> historico() {
        return Collections.unmodifiableList(historico);
    }

    /**
     * Mostra a quantidade de pacientes cadastrados
     */
    public int totalCadastrados() {
        return cadastros.size();
    }
}