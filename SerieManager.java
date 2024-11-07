import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerieManager {
    private List<Serie> series;
    private static final String FILE_NAME = "series.dat";

    public SerieManager() {
        series = loadSeries();
    }

    public void adicionarSerie(String nome, int episodioAtual, int avaliacao) {
        series.add(new Serie(nome, episodioAtual, avaliacao));
        saveSeries();
    }

    public void listarSeries() {
        if (series.isEmpty()) {
            System.out.println("Nenhuma série cadastrada.");
        } else {
            for (Serie serie : series) {
                System.out.println(serie);
            }
        }
    }

    public Serie buscarSerie(String nome) {
        for (Serie serie : series) {
            if (serie.getNome().equalsIgnoreCase(nome)) {
                return serie;
            }
        }
        return null;
    }

    public void atualizarSerie(String nome, int episodioAtual, int avaliacao) {
        Serie serie = buscarSerie(nome);
        if (serie != null) {
            serie.setEpisodioAtual(episodioAtual);
            serie.setAvaliacao(avaliacao);
            saveSeries();
            System.out.println("Série atualizada com sucesso.");
        } else {
            System.out.println("Série não encontrada.");
        }
    }

    public void removerSerie(String nome) {
        Serie serie = buscarSerie(nome);
        if (serie != null) {
            series.remove(serie);
            saveSeries();
            System.out.println("Série removida com sucesso.");
        } else {
            System.out.println("Série não encontrada.");
        }
    }

    private void saveSeries() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(series);
        } catch (IOException e) {
            System.out.println("Erro ao salvar séries: " + e.getMessage());
        }
    }

    private List<Serie> loadSeries() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Serie>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
