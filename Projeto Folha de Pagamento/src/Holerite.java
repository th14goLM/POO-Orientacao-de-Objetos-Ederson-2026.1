import java.text.NumberFormat;
import java.util.Locale;

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
        Locale localBR = new Locale("pt", "BR");
        NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(localBR);

        IO.println("+-----------------------------------+");
        IO.println(String.format("| %-33s |", "Holerite"));
        IO.println("+-----------------------------------+");
        System.out.println("| Funcionário: " + funcionario.getNome());
        System.out.println("| Salário Normal: " + formatadorMoeda.format(valorHorasNormais));
        System.out.println("| Salário Extras: " + formatadorMoeda.format(valorHorasExtras));
        System.out.println("| Adicional Filhos: " + formatadorMoeda.format(adicionalFilhos));
        IO.println("+-----------------------------------+");
        IO.println(String.format("| Total:" + formatadorMoeda.format(calcularTotal())));
        IO.println("+-----------------------------------+");
    }
}
