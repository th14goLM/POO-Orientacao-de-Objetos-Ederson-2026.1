class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public void emitirSom() {
        IO.println(nome + " faz um som.");
    }
}

class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome);
    }
    @Override
    public void emitirSom() {
        IO.println(nome + " Late: au auuuuuuuuuuuu!");
    }
}

void main(String[] args){
    Animal a = new Animal("Bicho");
    a.emitirSom();

    Cachorro c = new Cachorro("Max");
    c.emitirSom();
}