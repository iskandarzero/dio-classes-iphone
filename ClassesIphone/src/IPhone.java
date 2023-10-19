import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IPhone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {
    // Atributos
    private Map<String, Long> listaContatos;
    private List<Pagina> listaPaginas;
    private List<Musica> listaReproducao;

    public IPhone() {
        this.listaReproducao = new ArrayList<>();
        this.listaPaginas = new ArrayList<>();
        this.listaContatos = new HashMap<>();
    }

    // Aparelho Telefônico
    public void adicionarContato(String nome, Long numero) {
        listaContatos.put(nome, numero);
    }

    public void ligar(String nome) {
        if(!listaContatos.isEmpty()) {
            for(String n:listaContatos.keySet()) {
                if(n.equalsIgnoreCase(nome)) {
                    System.out.println("Ligando para " + listaContatos.get(n));
                }
            }
        } else {
            System.out.println("O contato não existe.");
        }
    }

    public void atender() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Recebendo ligação. Atender? (S/N)");
            String resposta = scan.nextLine();
            if(resposta.toLowerCase().equals("s")) {
                System.out.println("Ligação atendida.");
            } else {
                iniciarCorreioVoz();
            }
        } finally {
            scan.close();
        }
    }

    public void iniciarCorreioVoz() {
        System.out.println("Enviando a ligação para a caixa postal.");
    }

    // Navegador Internet
    public void exibirPagina() {
        if(!listaPaginas.isEmpty()) {
            System.out.println("Exibindo a página " + listaPaginas.get(0));
        } else {
            System.out.println("Não tem nenhuma aba aberta.");
        }
    }

    public void adicionarNovaAba(String nome, String url) {
        listaPaginas.add(new Pagina(nome, url));
    }

    public void atualizarPagina() {
        if(!listaPaginas.isEmpty()) {
            System.out.println("A página " + listaPaginas.get(0) + " foi atualizada.");
        } else {
            System.out.println("Não tem nenhuma aba aberta.");
        }
    }

    // Reprodutor Musical
    public void adicionarMusica(String nome, String artista, Double duracao) {
        listaReproducao.add(new Musica(nome, artista, duracao));
        System.out.println(nome + " foi adicionada na fila.");
    }

    public void tocar() {
        if(!listaReproducao.isEmpty()) {
            System.out.println("A música " + listaReproducao.get(0) + " está tocando.");
        } else {
            System.out.println("Não tem nenhuma música na fila de reprodução.");
        }
    }

    public void pausar() {
        if(!listaReproducao.isEmpty()) {
            System.out.println("A música " + listaReproducao.get(0) + " está pausada.");
        } else {
            System.out.println("Não tem nenhuma música na fila de reprodução.");
        }
    }

    public void selecionarMusica() {
        if(!listaReproducao.isEmpty()) {
            listaReproducao.remove(0);
            System.out.println("A música " + listaReproducao.get(0) + " foi selecionada.");
        } else {
            System.out.println("Não tem nenhuma música na fila de reprodução.");
        }
    }

    public void exibirReproducao() {
        if(!listaReproducao.isEmpty()) {
            System.out.println(listaReproducao);
        } else {
            System.out.println("Não tem nenhuma música na fila de reprodução.");
        }
    }
}

class App {
    public static void main(String[] args) {
        IPhone meuIphone = new IPhone();
        // Adicionando Contatos
        meuIphone.adicionarContato("Vini", 99887766L);
        meuIphone.adicionarContato("Ari", 99776655L);
        meuIphone.adicionarContato("Gui", 99112233L);
        // Adicionando Abas
        meuIphone.adicionarNovaAba("Twitter", "https://twitter.com/");
        meuIphone.adicionarNovaAba("YouTube", "https://www.youtube.com/");
        // Adicionando Música
        meuIphone.adicionarMusica("OTONABLUE", "Atarashii Gakko!", 3.10);
        meuIphone.adicionarMusica("Delírios", "FBC", 2.44);
        meuIphone.adicionarMusica("Kamome ga tonda Hi", "DELUXExDELUXE", 3.16);
        // Testando Aparelho Telefônico
        meuIphone.ligar("vini");
        meuIphone.atender();
        // Testando Navegador Internet
        meuIphone.exibirPagina();
        meuIphone.atualizarPagina();
        // Testando Reprodutor Musical
        meuIphone.tocar();
        meuIphone.selecionarMusica();
        meuIphone.pausar();
        meuIphone.exibirReproducao();
    }
}
