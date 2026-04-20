import Exception.*;
import Model.*;
import Service.*;

import java.util.Scanner;

import static java.lang.IO.*;

void main() {
    var fluxo = new FluxoDeAtendimento();
    var fila = new QueueManager();
    var scanner = new Scanner(System.in);

    println("""
            ╔══════════════════════════════════════╗
            ║   SISTEMA DE FILA DE ATENDIMENTO     ║
            ╚══════════════════════════════════════╝
            """);

    boolean rodando = true;

    while (rodando) {
        println("""
                │  1 - Cadastrar paciente
                │  2 - Chamar próximo
                │  3 - Ver fila
                │  4 - Buscar por CPF
                │  5 - Relatório final
                │  0 - Sair
                """);
        print("Opção: ");
        String opcao = scanner.nextLine();
        switch (opcao) {
            case "1" -> cadastrar(fluxo, fila, scanner);
            case "2" -> chamarProximo(fluxo, fila);
            case "3" -> verFila(fila);
            case "4" -> buscarPorCpf(fluxo, scanner);
            case "5" -> relatorio(fluxo);
            case "0" -> rodando = false;
            default  -> println("  Opção inválida. Tente novamente.\n");
        }
    }
    println("\nSistema finalizado ");
}

void cadastrar(FluxoDeAtendimento fluxo, QueueManager fila, Scanner scanner) {
    println("\n── Cadastro de Paciente ──");
    print("Nome: ");
    String nome = scanner.nextLine();

    print("CPF (somente números ou com pontuação): ");
    String cpf = scanner.nextLine().trim();

    print("Plano de saúde: ");
    String plano = scanner.nextLine().trim();

    println("Tipo de prioridade:");
    println("  1 - Idoso");
    println("  2 - Gestante");
    println("  3 - Deficiente");
    println("  4 - Normal");
    print("Opção: ");

    TipoPrioridade prioridade = switch (scanner.nextLine().trim()) {
        case "1" -> TipoPrioridade.IDOSO;
        case "2" -> TipoPrioridade.GESTANTE;
        case "3" -> TipoPrioridade.DEFICIENTE;
        default  -> TipoPrioridade.NORMAL;
    };

    try {
        Atendimento a = fluxo.novoPaciente(nome, cpf, plano, prioridade);
        fila.adicionar(a);
        println("\n  ✔ Cadastrado com sucesso!");
        println(" Nome  : " + a.paciente().nome());
        println(" Senha : " + a.senha());
        println(" Prioridade: " + a.prioridade());
        println(" Na fila agora: " + fila.tamanho() + " paciente(s)\n");
    } catch (CpfCadastradoException e) {
        println("\n CPF já cadastrado: " + e.getMessage() + "\n");
    } catch (IllegalArgumentException e) {
        println("\n Dado inválido: " + e.getMessage() + "\n");
    }
}

void chamarProximo(FluxoDeAtendimento fluxo, QueueManager fila) {
    println("\n── Chamando Próximo ──");
    try {
        Atendimento a = fila.chamarProximo();

        println("\n | Paciente: " + a.paciente().nome()
                + " | Senha: " + a.senha()
                + (a.prioridade() != TipoPrioridade.NORMAL ? " [" + a.prioridade() + "]" : ""));

        while (!(a.estado() instanceof Finalizado)) {
            println(" └─ " + a.paciente().nome()
                    + " → " + a.estado().getClass().getSimpleName());
            a = fluxo.avancar(a);
        }

        fluxo.registrarFinalizado(a);
        println(" └─ Finalizado.\n");

    } catch (FilaVaziaException e) {
        println("\n  ✘ " + e.getMessage() + "\n");
    }
}

void verFila(QueueManager fila) {
    println("\n── Situação da Fila ──");
    try {
        var proximo = fila.verProximo();
        println("  " + fila.tamanho() + " paciente(s) aguardando.");
        println("  Próximo: " + proximo.paciente().nome()
                + " | Senha: " + proximo.senha()
                + " | " + (proximo.prioritario() ? "PRIORITÁRIO" : "Normal") + "\n");
    } catch (FilaVaziaException e) {
        println("\n  ✘ " + e.getMessage() + "\n");
    }
}

void buscarPorCpf(FluxoDeAtendimento fluxo, Scanner scanner) {
    println("\n── Busca por CPF ──");
    print("CPF (somente números ou com pontuação): ");
    String cpf = scanner.nextLine().trim();

    try {
        var paciente = fluxo.buscarPorCpf(cpf);
        println("\n  ✔ Paciente encontrado!");
        println("  " + paciente);
        println();
    } catch (PacienteNaoEncontradoException e) {
        println("\n  ✘ " + e.getMessage() + "\n");
    }
}


void relatorio(FluxoDeAtendimento fluxo) {
    println("\n── Relatório de Atendimentos ──");
    var hist = fluxo.historico();
    if (hist.isEmpty()) {
        println("  Nenhum atendimento finalizado ainda.\n");
        return;
    }

    hist.forEach(a -> println("• %-20s | %s | Chegada: %s | %s".formatted(
                    a.paciente().nome(),
                    a.senha(),
                    a.horaChegada().toLocalTime().withNano(0),
                    a.prioritario() ? "PRIORITÁRIO" : "Normal")));

    println("\n  Total atendidos : " + hist.size());
    println("  Cadastros totais: " + fluxo.totalCadastrados() + "\n");
}