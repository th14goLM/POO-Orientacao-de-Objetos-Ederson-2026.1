void main() {
    LinkedList<String> filaAtendimento = new LinkedList<>();

    filaAtendimento.add("Carlos");
    filaAtendimento.add("Domingos");
    filaAtendimento.add("Felipe");
    filaAtendimento.add("João");
    filaAtendimento.add("Guilherme");

    IO.println("Fila Inicial: " + filaAtendimento);

    filaAtendimento.addFirst("Prioridade - Isabella");
    IO.println("Após adicionar prioridade: " + filaAtendimento);

    String atendido = filaAtendimento.removeFirst();
    IO.println("Pessoa Atendida: " + atendido);

    IO.println("Fila Atual: " + filaAtendimento);

    IO.println("Proximo da fila: " + filaAtendimento.getFirst());
    IO.println("Ultimo da Fila: " + filaAtendimento.getLast());


}


