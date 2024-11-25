import java.util.ArrayList;
import java.util.List;


class Discos {
    private String titulo;
    private int anoLancamento;
    private List<String> faixas;
    private Artistas artista;

    public Discos(String titulo, int anoLancamento) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.faixas = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setArtista(Artistas artista) {
        this.artista = artista;
    }

    public void adicionarFaixa(String faixa) {
        faixas.add(faixa);
    }

    public void listarFaixas() {
        System.out.println("Faixas:");
        for (String faixa : faixas) {
            System.out.println(" - " + faixa);
        }
    }

    public List<String> getFaixas() {
        return faixas;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\nAno: " + anoLancamento +
                "\nArtista: " + (artista != null ? artista.getNome() : "Desconhecido");
    }
}