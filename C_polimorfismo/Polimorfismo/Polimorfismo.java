class Animal{
    public void emitirSom(){
        IO.println("Animal faz um som!");
    }
}

class Cachorro extends Animal{
    @Override
    public void emitirSom(){
        IO.println("Cachorro late: au au!!");
    }
}

class Shark extends Animal{
    @Override
    public void emitirSom(){
        IO.println("Shark não faz um som! ele morde com força!!");
    }
}

public class Polimorfismo {
    static void main(){
        Animal a1 = new Cachorro();
        Animal a2 = new Shark();

        a1.emitirSom();
        a2.emitirSom();

        Animal[] animals = {new Animal(), new Cachorro(), new Shark()};

        for (Animal a: animals){
            a.emitirSom();
        }
    }
}
