package rpg.telas;

import java.util.Scanner;
import rpg.personagens.BasePersonagens;
import rpg.itens.Inventario;

public class TelaCombate {

    private BasePersonagens jogador;
    private BasePersonagens inimigo;
    private Scanner input;

    public TelaCombate(BasePersonagens jogador, BasePersonagens inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.input = new Scanner(System.in);
    }

    public void exibirTelaCombate() throws Exception {
        while (jogador.getPontosVida() > 0 && inimigo.getPontosVida() > 0) {
            exibirStatus();

            System.out.println("\n=== ESCOLHA SUA AÇÃO ===");
            System.out.println("1 - Atacar");
            System.out.println("2 - Esquivar");
            System.out.println("3 - Fugir");
            System.out.println("4 - Mostrar inventario");
            System.out.println("5 - Usar item");


            System.out.print("\nDigite sua escolha: ");
            int opcao = input.nextInt();
            executarAcao(opcao);

            if (opcao == 3) break; // fugiu
            Thread.sleep(1000); // pausa pra dar ritmo
        }

        if (jogador.getPontosVida() <= 0) {
            System.out.println("\n Você foi derrotado!");
        } else if (inimigo.getPontosVida() <= 0) {
            System.out.println("\n Você venceu o inimigo!");
        } else {
            System.out.println("\nVocê fugiu da batalha.");
        }
    }

    private void executarAcao(int opcao) throws Exception {
        switch (opcao) {
            case 1:
                System.out.println("Você atacou " + inimigo.getNome() + "!");
                inimigo.setPontosVida(Math.max(0, inimigo.getPontosVida() - jogador.getAtaque()));
                break;
            case 2:
                System.out.println("Você tenta esquivar do próximo ataque...");
                break;
            case 3:
                System.out.println("Você decide fugir da batalha...");
                break;
            case 4:
                System.out.println("Seu inventario: ");
                jogador.getInventario().mostrarInventario();
                break;
            case 5:
                System.out.println("Voce usou o item: ");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void exibirStatus() {
        System.out.println("=========================================");
        System.out.printf("%s (Nível %d) - Vida: %d\n", jogador.getNome(), jogador.getNivel(), jogador.getPontosVida());
        System.out.printf(" %s (Nível %d) - Vida: %d\n", inimigo.getNome(), inimigo.getNivel(), inimigo.getPontosVida());
        System.out.println("=========================================");
    }

}
