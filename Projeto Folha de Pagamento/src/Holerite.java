public class Holerite {
    private Funcionario funcionario;
    private double valorHorasNormais;
    private double valorHorasExtras;
    private double adicionalFilhos;

    /** Construtor **/
    public Holerite(Funcionario funcionario, double valorHorasNormais, double valorHorasExtras,  double adicionalFilhos) {
        this.funcionario = funcionario;
        this.valorHorasNormais = valorHorasNormais;
        this.valorHorasExtras = valorHorasExtras;
        this.adicionalFilhos = adicionalFilhos;
    }

    /** Calculo do salário total **/
    public double calcularTotal(){
        return this.valorHorasNormais + this.valorHorasExtras + this.adicionalFilhos;
    }

    /** Impressão do holerite final **/
    public void imprimir() {
        IO.println("+---- Holerite -----");
        IO.println("| Funcionario:" + funcionario.getNome() + " |");
        IO.println("| Salario Normal: R$" + valorHorasNormais + " |");
        IO.println("| Salario Extras: R$" + valorHorasExtras + " |");
        IO.println("| Adicional Filhos: R$" + adicionalFilhos + " |");
        IO.println("+-------------------");
        IO.println("| Valor Total a receber: R$" + calcularTotal() + " |");
        IO.println("+-------------------");
    }
}
