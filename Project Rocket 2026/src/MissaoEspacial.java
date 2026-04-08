void main() {
    CentroControle controle = new CentroControle();

    // Construtor de foguetes e satelites
    Foguete falcon = new Foguete("Falcon XII", 800, 50);
    Foguete apollo = new Foguete("Apollo XI", 1200, 30);
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

//    boolean missaoAtiva = true;
//    while (missaoAtiva) {
//        IO.println("\n===== 🌍 BASE DE LANÇAMENTO ESPACIAL =====");
//        IO.println("1 - Iniciar Nova Missão (Lançar Foguete)");
//        IO.println("2 - Ver Status de todos os Equipamentos");
//        IO.println("3 - Abastecer Foguete");
//        IO.println("4 - Encerrar Programa");
//        IO.println("==========================================");
//        IO.println("Digite o número da opção desejada:");
//        String opcao = IO.readln();
//
//        switch (opcao) {
//            case "1":
//                IO.println("\n🚀 Foguetes disponíveis: Falcon XII, Apollo XI, Roadster");
//                IO.println("Digite o nome exato do Foguete:");
//                String nomeFoguete = IO.readln().toLowerCase();
//
//                IO.println("\n🛰 Satélites disponíveis: Sputnik, Hubble, JamesWebb");
//                IO.println("Digite o nome exato do Satélite:");
//                String nomeSatelite = IO.readln().toLowerCase();
//
//                boolean sucesso = controle.iniciarMissao(nomeFoguete, nomeSatelite);
//                if (sucesso) {
//                    IO.println("\n--- 🌌 Operações Pós-Lançamento ---");
//                    controle.ativarPaineisSatelite(nomeSatelite);
//                    controle.definirOrbitaSatelite(nomeSatelite);
//                    controle.ativarSateliteOrbita(nomeSatelite);
//                    controle.enviarDadosSatelite(nomeSatelite);
//                } else {
//                    IO.println("❌ Lançamento abortado.");
//                }
//                break;
//
//            case "2":
//                controle.statusMissao();
//                break;
//
//            case "3":
//                IO.println("\n🚀 Foguetes disponíveis: Falcon XII, Apollo XI, Roadster");
//                IO.println("Digite o nome do Foguete para abastecer:");
//                String fogueteAbastecer = IO.readln();
//
//                if(fogueteAbastecer.equals("Falcon XII")) falcon.abastecer(50);
//                else if(fogueteAbastecer.equals("Apollo XI")) apollo.abastecer(50);
//                else if(fogueteAbastecer.equals("Roadster")) roadster.abastecer(50);
//                else IO.println("⚠ Foguete não encontrado.");
//                break;
//
//            case "4":
//                missaoAtiva = false;
//                IO.println("Saindo do Centro de Controle!");
//                break;
//
//            default:
//                IO.println("⚠ Opção inválida.");
//        }
//    }
//
//    // Relatório final exibido após o usuário escolher a opção 4
//    IO.println("\n===== 📋 RELATÓRIO FINAL DA MISSÃO =====");
//    controle.statusMissao();
//}
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
        controle.carregarEnergia("Hubble");
        controle.definirTipoSatelite("Hubble");
        IO.println();
        controle.enviarDadosSatelite("Hubble");
    }else{
        IO.println("❌ Missão falhou. Operações do satélite canceladas.");
    }

    // Verficação se já foi lançado
    boolean missaoFalcon2 = controle.iniciarMissao("Falcon XII", "Hubble");
    if (missaoFalcon2){
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