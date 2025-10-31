package rpg.telas;

import java.util.Scanner;
import rpg.Dados;
import rpg.Jogo;
import rpg.itens.*;
import rpg.personagens.BasePersonagens;
import rpg.personagens.inimigos.Monstros;

public class TelaCombate {

    private BasePersonagens jogador;
    private Monstros inimigo;
    private Scanner input;

    public TelaCombate(BasePersonagens jogador, Monstros inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.input = new Scanner(System.in);
    }

    public void exibirTelaCombate() throws Exception {
        while (jogador.getPontosVida() > 0 && inimigo.getPontosVida() > 0) {
            exibirStatus();
            System.out.println("\n=== ESCOLHA SUA AÇÃO ===");
            System.out.println("1 - Atacar");
            System.out.println("2 - Fugir");
            System.out.println("3 - Mostrar Inventario");
            System.out.println("4 - Usar item");
            System.out.println("5 - Ataque Especial");


            System.out.print("\nDigite sua escolha: ");
            int opcao = input.nextInt();
            executarAcao(opcao);
            if (inimigo.getPontosVida() <= 0) {
                System.out.println("\n Você venceu o inimigo!");
                break;
            }
            String classeinimigo = inimigo.getClass().getSimpleName();
            switch (classeinimigo){
                case "SoldadoDaDitadura":
                    jogador.subtraiVida(inimigo.soco() - jogador.getDefesa());
                    break;
                case "SargentoDaDitadura":
                    System.out.println(inimigo.getAtaque());
                    jogador.subtraiVida(inimigo.soco() - jogador.getDefesa());
                    break;
                case "CapitaoDaDitadura":
                    jogador.subtraiVida(inimigo.tiro() - jogador.getDefesa());
                    break;
                default:
                    int d = Dados.D6();
                    System.out.println("Default da Ditadura");
                    switch (d){
                        case 1:
                            jogador.subtraiVida(inimigo.soco() - jogador.getDefesa());
                            break;
                        case 2:
                            jogador.subtraiVida(inimigo.facada() - jogador.getDefesa());
                            break;
                        case 3:
                            jogador.subtraiVida(inimigo.tiro() - jogador.getDefesa());
                            break;
                        case 4:
                            jogador.subtraiVida(inimigo.tiro() - jogador.getDefesa());
                            break;
                        case 5:
                            jogador.subtraiVida(inimigo.raioLaser() -  jogador.getDefesa());
                            break;
                        default:
                            jogador.subtraiVida(inimigo.instrumentoProfano() - jogador.getDefesa());
                            break;
                    }
            }
            if (jogador.getPontosVida() <= 0) {
                System.out.println("\n Você foi derrotado!");
                break;
            }
            if (opcao == 2)  {
                if (Jogo.fugir(jogador) == 0){
                    System.out.println("\nVocê fugiu da batalha.");
                    break; // fugiu
                }
            }
            Thread.sleep(1000); // pausa pra dar ritmo
        }


    }

    private void executarAcao(int opcao) throws Exception {
        switch (opcao) {
            case 1:
                System.out.println("Você atacou " + inimigo.getNome() + "!");
                inimigo.subtraiVida(Math.max(0, (int)(jogador.getAtaque() * Dados.D4() / 1.5)));
                break;
            case 2:
                System.out.println("Você decide fugir da batalha...");
                Jogo.fugir(jogador);
                break;
            case 3:
                System.out.println("Seu inventario: ");
                jogador.getInventario().mostrarInventario();
                break;
            case 4:
                System.out.println("Voce usou o item: ");
                usarItemEmCombate();
                break;
            case 5:
                System.out.println("Voce usou o ataque especial");
                jogador.habilidadeEspecial(inimigo);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void usarItemEmCombate() throws Exception {
        var inv = jogador.getInventario();
        var lista = inv.listarItensOrdenados();

        if (lista.isEmpty()) {
            System.out.println("Seu inventário está vazio.");
            return;
        }

        System.out.println("Escolha um item para usar:");
        for (int i = 0; i < lista.size(); i++) {
            var it = lista.get(i);
            System.out.printf("%d) %s x%d — %s (%s)%n",
                    (i + 1), it.getNome(), it.getQuantidade(), it.getDescricao(), it.getEfeito());
        }

        System.out.print("Número do item: ");
        int idx = input.nextInt();
        if (idx < 1 || idx > lista.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        Itens itemEscolhido = lista.get(idx - 1);
        Jogo.usarItem(jogador, inimigo, itemEscolhido);
    }


    private void exibirStatus() {
        System.out.println("=========================================");
        System.out.printf("%s (Nível %d) - Vida: %d\n", jogador.getNome(), jogador.getNivel(), jogador.getPontosVida());
        System.out.printf(" %s (Nível %d) - Vida: %d\n", inimigo.getNome(), inimigo.getNivel(), inimigo.getPontosVida());
        System.out.println("=========================================");
    }

}
