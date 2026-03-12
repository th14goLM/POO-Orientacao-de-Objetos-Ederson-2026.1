void main() {
    CentroControle controle = new CentroControle();

    // Construtor de foguetes e satelites
    Foguete falcon = new Foguete("Falcon XII", 80, 80);
    Foguete apollo = new Foguete("Apollo XI", 120, 0);

    Satelite sputnik = new Satelite("Sputnik", 250, 50, "A ser definida!","Espionagem");
    Satelite hubble = new Satelite("Hubble", 400, 5, "GEO", "Científico");
    Satelite jamesWebb = new Satelite("JamesWebb", 850, 20, "Órbita Lunar", "Comunicação");

    // Chamada para adicionar os Foguetes
    controle.adicionarFoguete(falcon);
    controle.adicionarFoguete(apollo);

    // Chamada para adicionar os satélites
    controle.adicionarSatelite(sputnik);
    controle.adicionarSatelite(hubble);
    controle.adicionarSatelite(jamesWebb);

    // Imprime o Status da missão com dados dos foguetes e dos satélites
    controle.statusMissao();
    IO.println();

    // Abastecendo e iniciando a Missão de observação
    falcon.abastecer(50);
    controle.iniciarMissao("Falcon XII", "Hubble");
    IO.println();

    // Satélite em órbita da Terra
    controle.ativarPaineisSatelite("Hubble");
    IO.println();
    controle.definirOrbitaSatelite("Hubble");
    controle.ativarSateliteOrbita("Hubble");
    controle.definirTipoSatelite("Hubble");
    IO.println();
    controle.enviarDadosSatelite("Hubble");

    // Abastecendo e iniciando a Missão de comunicação
    apollo.abastecer(100);
    controle.iniciarMissao("Apollo XI", "JamesWebb");
    IO.println();

    // Satélite de comunicação no espaço
    controle.ativarPaineisSatelite("JamesWebb");
    IO.println();
    controle.definirOrbitaSatelite("JamesWebb");
    controle.ativarSateliteOrbita("JamesWebb");
    controle.definirTipoSatelite("JamesWebb");
    IO.println();
    controle.enviarDadosSatelite("JamesWebb");

    // Imprime o relatório após todas as instancias
    IO.println();
    IO.println("===== RELATÓRIO FINAL DA MISSÃO =====");
    controle.statusMissao();
}
