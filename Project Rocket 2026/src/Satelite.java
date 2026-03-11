public class Satelite {
    private String nome;
    private String orbitaAlvo;
    private String status;
    private String mensagem;
    private String tipoSatelite;
    private float massaKg;
    private float energia;

    private boolean paineisAtivos;

    public Satelite(String nome, float massaKg, float energia, String orbitaAlvo, String tipoSatelite) {
        this.nome = nome;
        this.massaKg = massaKg;
        this.energia = energia;
        this.orbitaAlvo = orbitaAlvo;
        this.status = "Em solo";
        this.tipoSatelite = tipoSatelite;
    }

    // Getters de satélite
    public String getNome() {
        return nome;
    }

    public float getMassaKg() {
        return massaKg;
    }

    public float getEnergia() {
        return energia;
    }

    public String getOrbitaAlvo() {
        return orbitaAlvo;
    }

    public String getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getTipoSatelite() {
        return tipoSatelite;
    }

    public boolean isPaineisAtivos() {
        return paineisAtivos;
    }

    // Setters de satélite
    public void setEnergia(float energia) {
        this.energia = energia;
    }

    public void setOrbitaAlvo(String orbitaAlvo) {
        this.orbitaAlvo = orbitaAlvo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setTipo(String tipoSatelite) {
        this.tipoSatelite = tipoSatelite;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPaineisAtivos(boolean paineisAtivos) {
        this.paineisAtivos = paineisAtivos;
    }

    // Método de ativação de paineis
    public void ativarPaineis() {
        if (energia >= 100) {
            IO.println("⚠ Energia do satélite está no máximo!");
            return;
        }

        if (!paineisAtivos) {
            IO.println("Iniciando abertura dos painéis...");
            IO.println("☀ Painéis solares ativados!");
            paineisAtivos = true;
            energia = Math.min(100, energia + 20);
            IO.println("Energia atual: " + energia);
        }
    }

    // Método para definição de tipo do satélite
    public void definirTipo(String tipoSatelite) {
        if(tipoSatelite == null || tipoSatelite.isEmpty()){
            IO.println("⚠ Tipo de satélite inválido.");
            return;
        }
        switch(tipoSatelite){
            case "Científico":
                setMensagem("Enviando dados meteorológicos sobre a Terra: 25° Graus Celsius, humidade em 90%");
                break;
            case "Comunicação":
                setMensagem("Estabeleceu comunicação interespacial com sucesso!");
                break;
            case "Espionagem":
                setMensagem("Captando sinais e imagens estratégicas da superfície.");
                break;
            default:
                IO.println("⚠ Tipo de satélite desconhecido.");
                return;
        }
        this.tipoSatelite = tipoSatelite;
    }

    // Método para exibir menu com órbitas
    public static void MenuOrbita() {
        IO.println("+--- Orbitas ---+");
        IO.println("| 1 - LEO");
        IO.println("| 2 - GEO");
        IO.println("| 3 - Órbita Lunar");
        IO.println("Digite qual a órbita desejada: ");
    }

    // Método que define a órbita do satélite
    public void definirOrbita(String escolha) {
        switch (escolha) {
            case "1":
                orbitaAlvo = "LEO";
                break;
            case "2":
                orbitaAlvo = "GEO";
                break;
            case "3":
                orbitaAlvo = "Órbita Lunar";
                break;
            default:
                IO.println("Órbita inválida");
                return;
        }
        status = "Em órbita";
    }

    // Método de ativação do satélite
    public void ativarSatelite() {
        if (status.equals("Em órbita")) {
            status = "Ativo";
            IO.println("🛰 Satélite " + nome + " agora está ATIVO!");
        } else {
            IO.println("⚠ Satélite ainda não está em órbita.");
        }
    }

    // Método de envio de dados via satélite
    public void enviarDados() {
        if (!status.equals("Ativo")) {
            IO.println("⚠ Satélite não está ativo e não pode enviar dados. Status atual: " + status);
            return;
        }

        if(energia < 10) {
            IO.println("⚠ Energia insuficiente para enviar os dados!");
            return;
        }

        energia -= 10;

        IO.println("+--- Mensagem Enviada ---+");
        IO.println("Satélite " + nome + ": " + mensagem);
    }

    // Método para impressão de relatório do satélite
    public void relatorioSatelite() {

        IO.println("+---Relatório do Satélite " + nome + "---+");
        IO.println("| Massa: " + massaKg + " kg");
        IO.println("| Energia: " + energia);
        IO.println("| Tipo de satelite: " + tipoSatelite);
        IO.println("| Órbita: " + orbitaAlvo);
        IO.println("| Status: " + status);
        if (mensagem == null){
            IO.println("| Mensagem: Nenhuma mensagem foi enviada!!");
        }else {
            IO.println("| Mensagem: " + mensagem);
            IO.println("+--------------------------------+");
        }
    }
}
