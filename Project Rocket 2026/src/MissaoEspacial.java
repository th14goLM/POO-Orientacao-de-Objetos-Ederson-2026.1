void main() {
    CentroControle controle = new CentroControle();

    // Construtor de foguetes e satelites
    Foguete falcon = new Foguete("Falcon XII", 800, 50);
    Foguete apollo = new Foguete("Apollo XI", 1200, 0);
    Foguete roadster = new Foguete("Roadster", 750, 100);

    Satelite sputnik = new Satelite("Sputnik", 250, 90, "A ser definida!", Satelite.TipoSatelite.ESPIONAGEM);
    Satelite hubble = new Satelite("Hubble", 400, 25, "GEO", Satelite.TipoSatelite.CIENTIFICO);
    Satelite jamesWebb = new Satelite("JamesWebb", 850, 20, "Órbita Lunar", Satelite.TipoSatelite.COMUNICACAO);

    // Chamada para adicionar os Foguetes
    controle.adicionarFoguete(falcon);
    controle.adicionarFoguete(apollo);
    controle.adicionarFoguete(roadster);
//    controle.adicionarFoguete(falcon);

    // Chamada para adicionar os satélites
    controle.adicionarSatelite(sputnik);
    controle.adicionarSatelite(hubble);
    controle.adicionarSatelite(jamesWebb);

    // Imprime o Status da missão com dados dos foguetes e dos satélites
    controle.statusMissao();
    IO.println();

    // Abastecendo e iniciando a Missão de observação
    falcon.abastecer(50);
    boolean missaoFalcon = controle.iniciarMissao("Falcon XII", "Hubble");
    if (missaoFalcon){
        IO.println();

        // Satélite em órbita da Terra
        controle.ativarPaineisSatelite("Hubble");
        IO.println();
        controle.definirOrbitaSatelite("Hubble");
        controle.ativarSateliteOrbita("Hubble");
        controle.definirTipoSatelite("Hubble");
        IO.println();
        controle.enviarDadosSatelite("Hubble");
    }else{
        IO.println("❌ Missão falhou. Operações do satélite canceladas.");
    }

    // Verficação se já foi lançado
//    boolean missaoFalcon2 = controle.iniciarMissao("Falcon XII", "Hubble");
//    if (missaoFalcon2){
//        IO.println();
//
//        // Satélite em órbita da Terra
//        controle.ativarPaineisSatelite("Hubble");
//        IO.println();
//        controle.definirOrbitaSatelite("Hubble");
//        controle.ativarSateliteOrbita("Hubble");
//        controle.definirTipoSatelite("Hubble");
//        IO.println();
//        controle.enviarDadosSatelite("Hubble");
//    }else{
//        IO.println("❌ Missão falhou. Operações do satélite canceladas.");
//    }

    // Abastecendo e iniciando a Missão de comunicação
    apollo.abastecer(25);
    boolean missaoApollo = controle.iniciarMissao("Apollo XI", "JamesWebb");
    if(missaoApollo){
        IO.println();

        // Satélite de comunicação
        controle.ativarPaineisSatelite("JamesWebb");
        IO.println();
        controle.definirOrbitaSatelite("JamesWebb");
        controle.ativarSateliteOrbita("JamesWebb");
        controle.definirTipoSatelite("JamesWebb");
        IO.println();
        controle.enviarDadosSatelite("JamesWebb");
    }else{
        IO.println("❌ Missão falhou. Operações do satélite canceladas.");
    }

    // Abastecendo e iniciando missão de espionagem
    roadster.abastecer(50);
    boolean missaoRoadster = controle.iniciarMissao("Roadster", "Sputnik");
    if (missaoRoadster){
        IO.println();

        // Satélite em órbita da Terra
        controle.ativarPaineisSatelite("Sputnik");
        IO.println();
        controle.definirOrbitaSatelite("Sputnik");
        controle.ativarSateliteOrbita("Sputnik");
        controle.definirTipoSatelite("Sputnik");
        IO.println();
        controle.enviarDadosSatelite("Sputnik");
    }else{
        IO.println("❌ Missão falhou. Operações do satélite canceladas.");
    }


    // Imprime o relatório após todas as instancias
    IO.println();
    IO.println("===== RELATÓRIO FINAL DA MISSÃO =====");
    controle.statusMissao();
}