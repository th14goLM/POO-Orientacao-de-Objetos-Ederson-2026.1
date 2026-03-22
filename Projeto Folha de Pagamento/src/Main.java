void main() {
    FolhaPagamento folhaPagamento = new FolhaPagamento();

    Funcionario funcionario1 = new Funcionario("Thiago",0);
    Funcionario funcionario2 = new Funcionario("Juan",0);
    Funcionario funcionario3 = new Funcionario("Larissa",3);

    ContratoTrabalho contratoTrabalho1 = new ContratoTrabalho(funcionario1,24,40);
    ContratoTrabalho contratoTrabalho2 = new ContratoTrabalho(funcionario2,32,60);
    ContratoTrabalho contratoTrabalho3 = new ContratoTrabalho(funcionario3,45,80);

    Holerite holeriteThiago = folhaPagamento.calcularSalario(contratoTrabalho1, 160, 10);
    Holerite holeriteJuan = folhaPagamento.calcularSalario(contratoTrabalho2, 160, 5);
    Holerite holeriteLarissa = folhaPagamento.calcularSalario(contratoTrabalho3, 160, 15);

    IO.println("+---- Folha de Pagamento -----+");
    holeriteThiago.imprimir();
    IO.println();

    holeriteJuan.imprimir();
    IO.println();

    holeriteLarissa.imprimir();
    IO.println();
}