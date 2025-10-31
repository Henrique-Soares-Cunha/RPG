package rpg;

import rpg.itens.*;
import rpg.personagens.heroi.*;
import rpg.personagens.inimigos.*;
import rpg.personagens.BasePersonagens;
import rpg.sons.narracao.Narracao;
import rpg.LeitorDeArquivosTxt;
import rpg.telas.*;
import rpg.Jogo;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static void printStatus(String titulo, BasePersonagens p) {
        System.out.printf("%s -> %s | Vida=%d, ATK=%d, DEF=%d, Nível=%d%n",
                titulo, p.getNome(), p.getPontosVida(), p.getAtaque(), p.getDefesa(), p.getNivel());
    }
    public static void main(String[] args) {
        try {
            Narracao narracao = new Narracao();
            narracao.tocarNarracao();


            LeitorDeArquivosTxt introdução = new LeitorDeArquivosTxt("Introducao.txt");
            LeitorDeArquivosTxt a1p1 = new LeitorDeArquivosTxt("A1P1.txt");
            /*LeitorDeArquivosTxt a1p2 = new LeitorDeArquivosTxt("A1P2.txt");
            LeitorDeArquivosTxt a2p1 = new LeitorDeArquivosTxt("A2P1.txt");
            LeitorDeArquivosTxt a2p2 = new LeitorDeArquivosTxt("A2P2.txt");
            LeitorDeArquivosTxt a3p1 = new LeitorDeArquivosTxt("A3P1.txt");
            LeitorDeArquivosTxt a3p2 = new LeitorDeArquivosTxt("A3P2.txt");
            LeitorDeArquivosTxt a4p1 = new LeitorDeArquivosTxt("A4P1.txt");
            LeitorDeArquivosTxt a4p2 = new LeitorDeArquivosTxt("A4P2.txt");
            LeitorDeArquivosTxt a5 = new LeitorDeArquivosTxt("A5Final.txt");
            introdução.lerArquivo();*/

            Scanner input = new Scanner(System.in);
            int o;
            System.out.println("escolha sua classe:\n" +
                    "1-Deejay, 2-Funkeiro, 3-Gospeiro, 4-Jazzista, 5-Metaleiro, 6-Rapper, 7-Pop Star, 8-Roqueiro, 9-Sambista");
            o = input.nextInt();
            System.out.println("Escolha um nome para seu personagem:" );
            String nome = input.nextLine();
            BasePersonagens heroi = null;
            switch (o){
                case 1:
                    heroi = new Deejay(nome, 5, 10 , 2 ,1);
                    break;
                case 2:
                    heroi = new Funkeiro(nome, 1, 1, 1, 1);
                    break;
                case 3:
                    heroi = new Gospeiro(nome,1,1,1,1);
                    break;
                case 4:
                    heroi = new Jazzista(nome,1,1,1,1);
                    break;
                case 5:
                    heroi = new Metaleiro(nome,1,1,1,1);
                    break;
                case 6:
                    heroi = new Rapper(nome,1,1,1,1);
                    break;
                case 7:
                    heroi = new PopStar(nome,1,1,1,1);
                    break;
                case 8:
                    heroi = new Roqueiro(nome,1,1,1,1);
                    break;
                case 9:
                    heroi = new Sambista(nome,1,1,1,1);
                    break;
                default:
                    System.out.println("Classe invalida");
                    break;
            }
            //a1p1.lerArquivo();

            TelaJogo.ChamarTela(heroi);
            if (heroi.getPontosVida() == 0) return;


        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
