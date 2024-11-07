import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SerieManager manager = new SerieManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Adicionar Série");
            System.out.println("2. Listar Séries");
            System.out.println("3. Atualizar Série");
            System.out.println("4. Remover Série");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome da série: ");
                    String nome = scanner.nextLine();
                    System.out.print("Episódio atual: ");
                    int episodioAtual = scanner.nextInt();
                    System.out.print("Avaliação (1 a 5): ");
                    int avaliacao = scanner.nextInt();
                    manager.adicionarSerie(nome, episodioAtual, avaliacao);
                    break;
                case 2:
                    manager.listarSeries();
                    break;
                case 3:
                    System.out.print("Nome da série para atualizar: ");
                    nome = scanner.nextLine();
                    System.out.print("Novo episódio atual: ");
                    episodioAtual = scanner.nextInt();
                    System.out.print("Nova avaliação (1 a 5): ");
                    avaliacao = scanner.nextInt();
                    manager.atualizarSerie(nome, episodioAtual, avaliacao);
                    break;
                case 4:
                    System.out.print("Nome da série para remover: ");
                    nome = scanner.nextLine();
                    manager.removerSerie(nome);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}