import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

void main() {
        Scanner scanner = new Scanner(System.in);
        FolhaPagamento folhaPagamento = new FolhaPagamento();

        /** Lista de funcionários com nome e quantidade de filhos**/
        List<Funcionario> listaDeFuncionarios = new ArrayList<>();
        listaDeFuncionarios.add(new Funcionario("Thiago", 1));
        listaDeFuncionarios.add(new Funcionario("Juan", 0));
        listaDeFuncionarios.add(new Funcionario("Larissa", 1));

        /** Lista de contrato de trabalho de cada funcionário**/
        List<ContratoTrabalho> listaDeContratos = new ArrayList<>();
        listaDeContratos.add(new ContratoTrabalho(listaDeFuncionarios.get(0), 25.0, 40.0));
        listaDeContratos.add(new ContratoTrabalho(listaDeFuncionarios.get(1), 32.0, 60.0));
        listaDeContratos.add(new ContratoTrabalho(listaDeFuncionarios.get(2), 45.0, 80.0));

        IO.println("+---- Folha de Pagamento -----+");

        /** For para busca de cada funcionario, faz com que ao perguntar ao usuário ele mude as informações**/
        for (ContratoTrabalho contratoAtual : listaDeContratos) {
            String nomeDoFuncionario = contratoAtual.getFuncionario().getNome();
            IO.println("Preenchendo a folha de pagamento de: " + nomeDoFuncionario);

            IO.print("Digite as horas trabalhadas: ");
            int horasNormais = scanner.nextInt();

            IO.print("Digite as horas extras trabalhadas: ");
            int horasExtras = scanner.nextInt();

            Holerite holeriteGerado = folhaPagamento.calcularSalario(contratoAtual, horasNormais, horasExtras);


            holeriteGerado.imprimir();
            IO.println();
        }
}