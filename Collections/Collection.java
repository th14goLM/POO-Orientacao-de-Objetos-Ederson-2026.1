void main() {
    ArrayList<Integer> numeros = new ArrayList<>();

    numeros.add(1);
    numeros.add(2);
    numeros.add(3);

    IO.println("ArrayList: " + numeros);

    Iterator<Integer> it = numeros.iterator();

    int numero = it.next();
    IO.println("Elemento: " + numero);

    while (it.hasNext()){
        it.forEachRemaining((value) -> IO.print(value + ", "));
    }
}


