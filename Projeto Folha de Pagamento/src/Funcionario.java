public class Funcionario {

    private String nome;
    private int qtdFilhos;

    /** Construtor **/
    public Funcionario(String nome, int qtdFilhos) {
        this.nome = nome;
        this.qtdFilhos = qtdFilhos;
    }

    /** Variável pra saber se o funcionário possui filhos **/
    public boolean possuiFilhos() {
        return this.qtdFilhos > 0;
    }

    /** Getters e Setters **/
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQtdFilhos() {
        return qtdFilhos;
    }
    public void setQtdFilhos(int qtdFilhos) {
        this.qtdFilhos = qtdFilhos;
    }

    @Override
    public String toString() {
        return "Funcionario: " + this.nome + " | Quantidade de Filhos: " + this.qtdFilhos;
    }
}
