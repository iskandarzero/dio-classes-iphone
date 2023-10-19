public interface AparelhoTelefonico {
    public void adicionarContato(String nome, Long numero);
    public void ligar(String nome);
    public void atender();
    public void iniciarCorreioVoz();
}