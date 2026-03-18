import java.util.ArrayList;
import java.util.List;

public class CentroControle {

    private final List<Foguete> foguetes;
    private final List<Satelite> satelites;

    // Classe para criar lista de objetos
    public CentroControle(){
        foguetes = new ArrayList<>();
        satelites = new ArrayList<>();
    }

    // Método para adicionar objetos
    public void adicionarFoguete(Foguete foguete){
        foguetes.add(foguete);
    }

    public void adicionarSatelite(Satelite satelite){
        satelites.add(satelite);
    }

    // Método de buscas para foguete e satélite
    private Foguete buscarFoguetePorNome(String nome){
        for(Foguete f : foguetes){
            if(f.getNome().equals(nome)){
                return f;
            }
        }
        return null;
    }

    private Satelite buscarSatelitePorNome(String nome){
        for(Satelite s : satelites){
            if(s.getNome().equals(nome)){
                return s;
            }
        }
        return null;
    }

    // Método para iniciar missão espacial, verificando seu status e imprimindo lançamento
    public boolean iniciarMissao(String nomeFoguete, String nomeSatelite){
        Foguete foguete = buscarFoguetePorNome(nomeFoguete);
        Satelite satelite = buscarSatelitePorNome(nomeSatelite);

        if(foguete == null || satelite == null){
            IO.println("⚠ Foguete ou satélite não encontrado.");
            return false;
        }

        boolean sucesso = foguete.lancar();

        if(sucesso){
            if (satelite.getMassaKg()>foguete.getCargaMaxima()){
                return false;
            }else {
                foguete.setSateliteCarregado(satelite);
                IO.println("🛰 Satélite carregado: " + nomeSatelite);
                return true;
            }
        }
        return false;
    }

    // Método para ativar os paineis do satélite
    public void ativarPaineisSatelite(String nome){
        Satelite s = buscarSatelitePorNome(nome);
        if(s == null){
            IO.println("⚠ Satélite não encontrado.");
            return;
        }
        s.ativarPaineis();
    }

    // Método que define a órbita do satélite
    public void definirOrbitaSatelite(String nome){
        Satelite s = buscarSatelitePorNome(nome);
        if(s == null){
            IO.println("⚠ Satélite não encontrado.");
            return;
        }
        Satelite.MenuOrbita();
        String escolha = IO.readln();
        s.definirOrbita(escolha);
    }

    // Método que ativa o satélite em órbita
    public void ativarSateliteOrbita(String nome){
        Satelite s = buscarSatelitePorNome(nome);
        if(s == null){
            IO.println("⚠ Satélite não encontrado.");
            return;
        }
        s.ativarSatelite();
    }

    // Método que envia dados via satélite
    public void enviarDadosSatelite(String nome){
        Satelite s = buscarSatelitePorNome(nome);
        if(s == null){
            IO.println("⚠ Satélite não encontrado.");
            return;
        }
        s.enviarDados();
    }

    // Método de definição do tipo de satélite
    public void definirTipoSatelite(String nome){
        Satelite s  = buscarSatelitePorNome(nome);
        if(s == null){
            IO.println("⚠ Satélite não encontrado.");
            return;
        }
        s.definirTipo(s.getTipoSatelite());
    }

    // Método para mostrar relatório da missão
    public void statusMissao(){
        IO.println("+--- STATUS DA MISSÃO ---+");
        IO.println("\n🚀 Foguetes:");
        for(Foguete f : foguetes){
            f.relatorioFoguete();
        }

        IO.println("\n🛰 Satélites:");
        for(Satelite s : satelites){
            s.relatorioSatelite();
        }
    }
}