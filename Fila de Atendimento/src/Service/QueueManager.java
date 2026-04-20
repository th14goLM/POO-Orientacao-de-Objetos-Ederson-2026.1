package Service;

import Exception.FilaVaziaException;
import Model.Atendimento;

import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

    /**
     * Gerencia a fila por:
     * 1. Prioridade (idosos, gestantes) — atendidos primeiro
     * 2. Hora de chegada é o que desempata entre pacientes do mesmo grupo
     */

public class QueueManager {

    private final Queue<Atendimento> fila = new PriorityBlockingQueue<>(
            100,
            Comparator.comparing((Atendimento a) -> a.prioridade().ordinal())
                    .thenComparing(Atendimento::horaChegada)
    );

    /**
     * Adiciona um atendimento à fila respeitando a ordenação de prioridade.
     */
    public void adicionar(Atendimento atendimento) {
        fila.add(atendimento);
    }

    /**
    * Remove e retorna o próximo paciente da fila
     */
    public Atendimento chamarProximo() {
        if (fila.isEmpty())
            throw new FilaVaziaException();
        return fila.poll();
    }

    /**
     * Faz a mesma coisa da função de chamar, porém esta não remove nenhum paciente
     */
    public Atendimento verProximo() {
        if (fila.isEmpty())
            throw new FilaVaziaException();
        return fila.peek();
    }

    /**
     * Variável para ver o tamanho da fila
     */
    public int tamanho() {
        return fila.size();
    }
}
