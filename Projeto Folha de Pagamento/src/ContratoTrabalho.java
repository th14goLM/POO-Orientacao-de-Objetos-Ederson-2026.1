public class ContratoTrabalho {
    private Funcionario funcionario;
    private double valorHoraNormal;
    private double valorHoraExtra;

    /** Construtor **/
    public ContratoTrabalho(Funcionario funcionario, double valorHoraNormal, double valorHoraExtra) {
        this.funcionario = funcionario;
        this.valorHoraNormal = valorHoraNormal;
        this.valorHoraExtra = valorHoraExtra;
    }

    /** getters e setters **/
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public double getValorHoraNormal() {
        return valorHoraNormal;
    }
    public void setValorHoraNormal(double valorHoraNormal) {
        this.valorHoraNormal = valorHoraNormal;
    }
    public double getValorHoraExtra() {
        return valorHoraExtra;
    }
    public void setValorHoraExtra(double valorHoraExtra) {
        this.valorHoraExtra = valorHoraExtra;
    }

    /** Verificador de adicional de 10% **/
    public boolean temAdicional() {
        return funcionario.possuiFilhos();
    }
}
