import Model.Paciente;

void main() {
    try {
        Paciente p1 = new Paciente("Thiago", "109.002.029-55", "Unimed");
        IO.println("Model.Paciente criado com sucesso!");
    } catch (IllegalArgumentException e) {
        System.err.println("Erro ao cadastrar: " + e.getMessage());
    }
}
//
//var fluxo = new FluxoService();
//var fila = new QueueManager();
//
// 1. Model.Paciente Chega
//Model.Paciente p1 = new Model.Paciente("João Silva", "12345678901", "Plano Unimed");
//
// 2. Recebe Senha e Insere na Fila
//Atendimento atendimento = fluxo.gerarNovoAtendimento(p1, false);
//        fila.entrarNaFila(atendimento);
//
//        System.out.println("Model.Paciente " + p1.nome() + " aguardando na fila...");
//
//         3. Simulação de processamento de etapas
//        Thread.startVirtualThread(() -> {
//Atendimento emAndamento = fila.chamarProximo();
//            System.out.println("Chamando: " + emAndamento.senha());
//
// Avançando pelas etapas emAndamento = fluxo.avancarEtapa(emAndamento); // Vai para Consulta
//           System.out.println("Status: " + emAndamento.estado().getClass().getSimpleName());
//        });
//}
