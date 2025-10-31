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
            System.out.println("voce o " + jogador.getNome() + "tem as opções");
            System.out.println("1-Explorar 2-usar item 3-tomar decisão");
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
                            System.out.println("Você achou o escudo armonica");
                            jogador.getInventario().adicionarItem(new Itens("escudo armonico", "um escudo superefetivo contra o regime" , 1, "almentar defesa"));
                            break;
                        case 4:
                            System.out.println("Você achou o escudo armonica");
                            jogador.getInventario().adicionarItem(new Itens("guitarra armonico", "uma guitarra superefetivo contra o regime" , 1, "almentar ataque"));
                            break;
                        default:


                    }
                case 2:
                    int b = Dados.Dpersonalizado(0, 10);
            }
            if (jogador.getPontosVida() == 0 ){
                return;
            }
        }
    }
}
