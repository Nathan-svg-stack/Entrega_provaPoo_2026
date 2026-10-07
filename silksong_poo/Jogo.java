import javax.swing.JOptionPane;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("HOLLOW KNIGHT: SILKSONG");
        System.out.println("edicao POO em Java");
        System.out.println("=================================");

        String nome = JOptionPane.showInputDialog("Digite seu nome:");
        System.out.println("Carregando save de " + nome + "...");

        Heroina heroina = new Heroina("Hornet");
        System.out.println(heroina);

        Inimigo chefe = new Inimigo("Moss Mother", 12, 1);

        Scanner scanner = new Scanner(System.in);

        int turno = 1;
        int opcao;
        boolean fugiu = false;

        do {
            System.out.println("========== Turno " + turno + " ==========");
            System.out.println(heroina);
            System.out.println(chefe);

            System.out.println("1-Atacar 2-Curar 0-Fugir");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    heroina.atacar();
                    chefe.receberGolpe();
                    break;

                case 2:
                    heroina.curar();
                    break;

                case 0:
                    System.out.println(heroina.getNome() + " fugiu da batalha.");
                    fugiu = true;
                    break;

                default:
                    System.out.println("Opcao invalida");
            }

            if (!fugiu && !chefe.estaDerrotado() && turno % 3 == 0) {
                System.out.println(chefe.getNome() + " ataca!");
                heroina.receberDano(chefe.getDano());
            }

            turno++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        } while (!fugiu && !chefe.estaDerrotado()
                && !heroina.estaDerrotada());

        if (chefe.estaDerrotado()) {
            System.out.println("Vitoria sobre " + chefe.getNome() + "!");
        } else if (heroina.estaDerrotada()) {
            System.out.println("Fim de jogo.");
        }

        System.out.println(heroina);

        scanner.close();

    }
}
