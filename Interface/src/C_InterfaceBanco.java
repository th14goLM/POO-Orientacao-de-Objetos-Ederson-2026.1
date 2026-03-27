import java.util.List;

interface ContaBancaria {
    void depositar(double valor);
    void sacar(double valor);

    default void transferirPara(ContaBancaria destino, double valor) {
        this.sacar(valor);
        destino.depositar(valor);
    }

    double getSaldo();
}

class ContaCorrente implements ContaBancaria {
    private double saldo;
    private final double limite;

    public ContaCorrente(double saldoInicial, double limite) {
        if (limite < 0) throw new IllegalArgumentException("Limite não pode ser negativo!");
        this.saldo = saldoInicial;
        this.limite = limite;
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor deve ser positivo!");
        saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Saque deve ser positivo!");
        if (saldo - valor < -limite) throw new IllegalArgumentException("Saldo insuficiente!");
        saldo -= valor;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }
}

class ContaPoupanca implements ContaBancaria {
    private double saldo;

    public ContaPoupanca(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Depósito deve ser positivo!");
        saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Saque deve ser positivo!");
        if (saldo - valor < 0) throw new IllegalArgumentException("Saldo insuficiente (poupança não permite negativo)!");
        saldo -= valor;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    public void renderJuros(double taxa) {
        if (taxa < 0) throw new IllegalArgumentException("Taxa inválida!");
        saldo *= (1 + taxa);
    }
}

class OperacoesBancarias {
    public double saldoTotal(List<ContaBancaria> contas) {
        double total = 0;
        for (ContaBancaria c : contas) {
            total += c.getSaldo();
        }
        return total; // ✅ adicionado
    }
}