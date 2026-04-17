import Model.*;
import Service.*;

import static java.lang.IO.*;

void main() {
    var fluxo = new FluxoDeAtendimento();
    var fila = new QueueManager();

    try {
        var atendimento = fluxo.novoPaciente("Thiago", "109.002.029-55", "Unimed", false);
        atendimento = fluxo.novoPaciente("Munirah", "02858023999", "Bradesco Seguro", true);
        fila.adicionar(atendimento);

        println("✅ Sucesso: " + atendimento.paciente());
        println("🎫 Senha Gerada: " + atendimento.senha());

        var emAndamento = fila.chamarProximo();
        println("\n--- Iniciando Fluxo ---");

        while (!(emAndamento.estado() instanceof Finalizado)) {
            println("Paciente " + emAndamento.paciente().nome() + " está em: " + emAndamento.estado().getClass().getSimpleName());
            emAndamento = fluxo.avancar(emAndamento);
        }
    } catch (IllegalArgumentException e) {
        System.err.println("Erro ao cadastrar: " + e.getMessage());
    }
}