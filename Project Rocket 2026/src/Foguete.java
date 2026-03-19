public class Foguete {
    private String nome;
    private float combustivelRestante;
    private float cargaMaxima;
    private String status;
    private Satelite sateliteCarregado;

    public Foguete(String nome, float cargaMaxima, float combustivelRestante) {
        this.nome = nome;
        this.cargaMaxima = cargaMaxima;
        this.combustivelRestante = combustivelRestante;
        this.status = "Pronto";
        this.sateliteCarregado = null;
    }

    // Getters do foguete
    public String getNome() {
        return nome;
    }

    public double getCombustivelRestante() {
        return combustivelRestante;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public String getStatus() {
        return status;
    }

    public Satelite getSateliteCarregado() {
        return sateliteCarregado;
    }

    // Setters do foguete
    public void setCombustivelRestante(float combustivelRestante) {
        this.combustivelRestante = combustivelRestante;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSateliteCarregado(Satelite sateliteCarregado) {
        this.sateliteCarregado = sateliteCarregado;
    }

    // Método de abastecimento do foguete
    public void abastecer(float quantidade) {
        if (quantidade > 0) {
            IO.println("\n+--- Abastecimento ---+");
            combustivelRestante += quantidade;
            IO.println(nome + " foi abastecido com " + quantidade + " toneladas de combustível.");
        }
    }

    // Método para lançamento do foguete verificando parâmetros
    public boolean lancar() {
        if (status.equals("Lançado")) {
            IO.println("⚠ O foguete " + nome + " já está no espaço!");
            return false;
        }

        if (combustivelRestante >= 50) {

            combustivelRestante -= 50;
            status = "Lançado";

            IO.println("🚀 " + nome + " lançado com sucesso! Combustível restante: " + combustivelRestante + " toneladas.");

            if (sateliteCarregado != null) {
                sateliteCarregado.setStatus("No espaço");
            }

            return true;
        } else {
            setStatus("Falha");
            IO.println("⚠ " + nome + " não possui combustível suficiente! (Mínimo: 50 toneladas)");
            return false;
        }
    }

    // Método que exibe o relatório do foguete
    public void relatorioFoguete() {
        IO.println("+--- Relatório do Foguete " + nome + " ---+");
        IO.println("Combustível restante: " + combustivelRestante + " toneladas");
        IO.println("Carga máxima: " + cargaMaxima + " kg");
        IO.println("Status: " + status);

        if (sateliteCarregado != null) {
            IO.println("Satélite carregado: " + sateliteCarregado.getNome());
        } else {
            IO.println("Satélite carregado: Nenhum");
        }

        IO.println("+--------------------------------------+");
    }
}