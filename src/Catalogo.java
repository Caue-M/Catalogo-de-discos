import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Discos> discos = new ArrayList<>();
    private List<Artistas> artistas = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void adicionarDisco() {
        System.out.print("Título do disco: ");
        String titulo = sc.nextLine();
        System.out.print("Ano de lançamento: ");
        int ano = sc.nextInt();
        sc.nextLine();

        Discos disco = new Discos(titulo, ano);

        System.out.print("Número de faixas: ");
        int numFaixas = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numFaixas; i++) {
            System.out.print("Nome da faixa " + (i + 1) + ": ");
            disco.adicionarFaixa(sc.nextLine());
        }

        discos.add(disco);
        System.out.println("Disco adicionado com sucesso!");
    }

    public void adicionarArtista() {
        System.out.print("Nome do artista: ");
        String nome = sc.nextLine();
        System.out.print("Gênero musical: ");
        String genero = sc.nextLine();

        artistas.add(new Artistas(nome, genero));
        System.out.println("Artista adicionado com sucesso!");
    }

    public void listarDiscos() {
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado :(");
            return;
        }
        for (Discos disco : discos) {
            System.out.println(disco);
            disco.listarFaixas();
        }
    }

    public void listarArtistas() {
        if (artistas.isEmpty()) {
            System.out.println("Nenhum artista cadastrado:( ");
            return;
        }
        for (Artistas artista : artistas) {
            System.out.println(artista);
        }
    }

    public void editarDisco() {
        System.out.print("Título do disco a editar: ");
        String titulo = sc.nextLine();

        for (Discos disco : discos) {
            if (disco.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.print("Novo título (pressione Enter para manter): ");
                String novoTitulo = sc.nextLine();
                if (!novoTitulo.isEmpty()) disco.setTitulo(novoTitulo);

                System.out.print("Novo ano de lançamento (pressione Enter para manter): ");
                String novoAno = sc.nextLine();
                if (!novoAno.isEmpty()) disco.setAnoLancamento(Integer.parseInt(novoAno));

                System.out.println("Disco editado com sucesso!");
                return;
            }
        }
        System.out.println("Disco não encontrado!");
    }

    public void editarArtista() {
        System.out.print("Nome do artista a editar: ");
        String nome = sc.nextLine();

        for (Artistas artista : artistas) {
            if (artista.getNome().equalsIgnoreCase(nome)) {
                System.out.print("Novo nome (pressione Enter para manter): ");
                String novoNome = sc.nextLine();
                if (!novoNome.isEmpty()) artista.setNome(novoNome);

                System.out.print("Novo gênero (pressione Enter para manter): ");
                String novoGenero = sc.nextLine();
                if (!novoGenero.isEmpty()) artista.setGenero(novoGenero);

                System.out.println("Artista editado com sucesso!");
                return;
            }
        }
        System.out.println("Artista não encontrado!");
    }

    public void removerDisco() {
        System.out.print("Título do disco a remover: ");
        String titulo = sc.nextLine();

        discos.removeIf(disco -> disco.getTitulo().equalsIgnoreCase(titulo));
        System.out.println("Disco removido.");
    }

    public void removerArtista() {
        System.out.print("Nome do artista a remover: ");
        String nome = sc.nextLine();

        artistas.removeIf(artista -> artista.getNome().equalsIgnoreCase(nome));
        System.out.println("Artista removido.");
    }

    public void associarArtista() {
        System.out.print("Título do disco para associar um artista: ");
        String tituloDisco = sc.nextLine();

        Discos discoEncontrado = null;
        for (Discos disco : discos) {
            if (disco.getTitulo().equalsIgnoreCase(tituloDisco)) {
                discoEncontrado = disco;
                break;
            }
        }

        if (discoEncontrado == null) {
            System.out.println("Disco não encontrado.");
            return;
        }

        System.out.print("Nome do artista a associar: ");
        String nomeArtista = sc.nextLine();

        for (Artistas artista : artistas) {
            if (artista.getNome().equalsIgnoreCase(nomeArtista)) {
                discoEncontrado.setArtista(artista);
                System.out.println("Artista associado com sucesso!");
                return;
            }
        }

        System.out.println("Artista não encontrado!");
    }

    public void editarFaixasDisco() {
        System.out.print("Título do disco para editar faixas: ");
        String titulo = sc.nextLine();

        for (Discos disco : discos) {
            if (disco.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("1 - Adicionar nova faixa");
                System.out.println("2 - Remover faixa existente");
                System.out.print("Escolha uma opção: ");
                int opcao = sc.nextInt();
                sc.nextLine();

                if (opcao == 1) {
                    System.out.print("Nome da nova faixa: ");
                    String novaFaixa = sc.nextLine();
                    disco.adicionarFaixa(novaFaixa);
                    System.out.println("Faixa adicionada com sucesso!");
                } else if (opcao == 2) {
                    System.out.println("Faixas existentes:");
                    List<String> faixas = disco.getFaixas();
                    for (int i = 0; i < faixas.size(); i++) {
                        System.out.println((i + 1) + " - " + faixas.get(i));
                    }
                    System.out.print("Número da faixa a remover: ");
                    int numeroFaixa = sc.nextInt();
                    sc.nextLine();
                    if (numeroFaixa > 0 && numeroFaixa <= faixas.size()) {
                        faixas.remove(numeroFaixa - 1);
                        System.out.println("Faixa removida com sucesso!");
                    } else {
                        System.out.println("Número inválido.");
                    }
                } else {
                    System.out.println("Opção inválida.");
                }
                return;
            }
        }

        System.out.println("Disco não encontrado.");
    }
}

