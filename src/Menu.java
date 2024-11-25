import java.util.Scanner;

public class Menu {
    public void exibirMenu() {
        Scanner sc = new Scanner(System.in);
        Catalogo catalogo = new Catalogo();
        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Adicionar Disco");
            System.out.println("2 - Adicionar Artista");
            System.out.println("3 - Listar Discos");
            System.out.println("4 - Listar Artistas");
            System.out.println("5 - Editar Disco");
            System.out.println("6 - Editar Artista");
            System.out.println("7 - Remover Disco");
            System.out.println("8 - Remover Artista");
            System.out.println("9 - Associar Artista a Disco");
            System.out.println("10 - Editar Faixas do Disco");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> catalogo.adicionarDisco();
                case 2 -> catalogo.adicionarArtista();
                case 3 -> catalogo.listarDiscos();
                case 4 -> catalogo.listarArtistas();
                case 5 -> catalogo.editarDisco();
                case 6 -> catalogo.editarArtista();
                case 7 -> catalogo.removerDisco();
                case 8 -> catalogo.removerArtista();
                case 9 -> catalogo.associarArtista();
                case 10 -> catalogo.editarFaixasDisco();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}
