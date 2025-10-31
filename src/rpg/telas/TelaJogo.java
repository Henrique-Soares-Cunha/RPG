package rpg.telas;

import rpg.Dados;
import rpg.itens.Itens;
import rpg.personagens.BasePersonagens;
import java.util.Scanner;
import rpg.Jogo;
import rpg.personagens.inimigos.*;

public class TelaJogo {

    public static void ChamarTela(BasePersonagens jogador) throws Exception {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("----------------------------------------------");
            System.out.println("Voce " + jogador.getNome() + "tem as opções");
            System.out.println("1-Explorar 2-Usar item 3-Tomar decisão 4-Mostrar inventario");
            System.out.println("----------------------------------------------");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    int a = Jogo.Explorar();
                    switch (a){
                        case 0:
                            TelaCombate armadilha = new TelaCombate(jogador, new SargentoDaDitadura("matheus", 1,1,1,1));
                            jogador.subtraiVida(2);
                            armadilha.exibirTelaCombate();
                            break;
                        case 1:
                            TelaCombate arapuca = new TelaCombate(jogador, new SargentoDaDitadura("PC", 1,1,1,1));
                            arapuca.exibirTelaCombate();
                            break;
                        case 3:
                            System.out.println("Você achou o Escudo Harmônico");
                            jogador.getInventario().adicionarItem(new Itens("Escudo Harmônico", "Um escudo superefetivo contra o regime", 1, "defesa"));
                            break;
                        case 4:
                            System.out.println("Você achou a Guitarra Harmonica");
                            jogador.getInventario().adicionarItem(new Itens("Guitarra Harmônica", "uma guitarra superefetivo contra o regime com som devastador" , 1, "dano"));
                            break;
                        default:


                    }
                    break;
                case 2:
                    var inv = jogador.getInventario();
                    var lista = inv.listarItensOrdenados();

                    if (lista.isEmpty()) {
                        System.out.println("Seu inventário está vazio.");
                        break;
                    }
                    System.out.println("Escolha um item para usar:");
                    for (int i = 0; i < lista.size(); i++) {
                        Itens it = lista.get(i);
                        System.out.printf("%d) %s x%d — %s%n",
                                (i + 1), it.getNome(), it.getQuantidade(), it.getDescricao());
                    }

                    System.out.print("Número do item: ");
                    int numeroItem = sc.nextInt();

                    if (numeroItem < 1 || numeroItem > lista.size()) {
                        System.out.println("Índice inválido.");
                        break;
                    }

                    Itens itemEscolhido = lista.get(numeroItem - 1);

                    if ("dano".equalsIgnoreCase(itemEscolhido.getEfeito())) {
                        System.out.println("Itens de dano só podem ser usados em combate.");
                    } else {
                        Jogo.usarItem(jogador, null, itemEscolhido); // buffs/cura
                    }
                    break;
                case 3:
                    break;
                case 4:
                    jogador.getInventario().mostrarInventario();
                    break;
                }
            }
    }
}

