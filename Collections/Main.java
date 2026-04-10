void main() {
    ArrayList<String> linguagens = new ArrayList<>();

    linguagens.add("java");
    linguagens.add("C#");
    linguagens.add("Python");
    linguagens.add("Python");
    linguagens.add("JavaScript");
    linguagens.add("Html");
    linguagens.add("C++");

    IO.println("ArrayList: " + linguagens);

    String[] arr = new String[linguagens.size()];

    linguagens.toArray(arr);
    IO.println("Array: ");

    for (String item:arr){
        IO.println(item + ", ");
    }
}