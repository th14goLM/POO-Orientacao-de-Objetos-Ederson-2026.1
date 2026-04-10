void main() {
    TreeSet<Integer> numeros = new TreeSet<>();
    numeros.add(8);
    numeros.add(6);
    numeros.add(9);
    numeros.add(2);

    IO.println("TreeSet: " + numeros);

    boolean result = numeros.remove(2 );
    IO.println("Removeu??: " + result);
    IO.println("TreeSet: " + numeros);

    boolean results = numeros.removeAll(numeros);
    IO.println("Removeu??: " + results);
    IO.println("TreeSet: " + numeros);
}


