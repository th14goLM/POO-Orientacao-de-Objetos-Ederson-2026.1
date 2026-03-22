import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in);
    FolhaPagamento folhaPagamento = new FolhaPagamento();
    List<Funcionario> listaDeFuncionarios = new ArrayList<>();
    List<ContratoTrabalho> listaDeContratos = new ArrayList<>();

    IO.println("+---- Empresa -----+");

    IO.print("Quantos funcionários deseja fazer o pagamento? ");
    int quantidade = scanner.nextInt();
    scanner.nextLine();

    IO.println("\n--- Iniciando Sistema ---");

    for (int i = 0; i < quantidade; i++) {
        IO.println("\nFuncionário " + (i + 1));

        IO.print("Nome: ");
        String nome = scanner.nextLine();

        IO.print("Quantidade de Filhos: ");
        int filhos = scanner.nextInt();

        IO.print("Valor da Hora Normal (ex: 25,0): ");
        double valorNormal = scanner.nextDouble();

        IO.print("Valor da Hora Extra (ex: 40,0): ");
        double valorExtra = scanner.nextDouble();
        scanner.nextLine();

        Funcionario novoFuncionario = new Funcionario(nome, filhos);
        ContratoTrabalho novoContrato = new ContratoTrabalho(novoFuncionario, valorNormal, valorExtra);

        listaDeFuncionarios.add(novoFuncionario);
        listaDeContratos.add(novoContrato);
    }

    IO.println("+---- Folha de Pagamento -----+");

    for (ContratoTrabalho contratoAtual : listaDeContratos) {
        String nomeDoFuncionario = contratoAtual.getFuncionario().getNome();
        IO.println("\nPreenchendo a folha de: " + nomeDoFuncionario);

        IO.print("Horas normais trabalhadas: ");
        int horasNormais = scanner.nextInt();

        IO.print("Horas extras trabalhadas: ");
        int horasExtras = scanner.nextInt();

        Holerite holeriteGerado = folhaPagamento.calcularSalario(contratoAtual, horasNormais, horasExtras);

        holeriteGerado.imprimir();
    }
}
