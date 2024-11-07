import java.io.Serializable;

public class Serie implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int episodioAtual;
    private int avaliacao;

    public Serie(String nome, int episodioAtual, int avaliacao) {
        this.nome = nome;
        this.episodioAtual = episodioAtual;
        this.avaliacao = avaliacao;
    }

    public String getNome() {
        return nome;
    }

    public int getEpisodioAtual() {
        return episodioAtual;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setEpisodioAtual(int episodioAtual) {
        this.episodioAtual = episodioAtual;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Episódio Atual: " + episodioAtual + ", Avaliação: " + avaliacao;
    }
}
