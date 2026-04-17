package Service;

import Model.Atendimento;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.Comparator;

public class QueueManager {

    //* Aqui é onde o sistema organiza a fila de atendimento. Ele recebe o novo atendimento gerado, verifica se possui o Boolean de prioridade como TRUE, e a hora da chegada.

    /*  Ordem de atendimento:
    *   -> Prioritário
    *   -> Hora de chegada
    * */

    private final Queue<Atendimento> fila = new PriorityBlockingQueue<>(100,
            Comparator.comparing(Atendimento::prioritario).reversed()
                    .thenComparing(Atendimento::horaChegada)
    );

    public void adicionar(Atendimento a) { fila.add(a); }
    public Atendimento chamarProximo() { return fila.poll(); }
    public boolean estaVazia() { return fila.isEmpty(); }
}
