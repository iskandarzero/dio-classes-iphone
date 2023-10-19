public class Musica {
    private String nome;
    private String artista;
    private Double duracao;

    public Musica(String nome, String artista, Double duracao) {
        this.nome = nome;
        this.artista = artista;
        this.duracao = duracao;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return this.artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Double getDuracao() {
        return this.duracao;
    }

    public void setDuracao(Double duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return getNome() + " - " + getArtista();
    }

}