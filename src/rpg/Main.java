package rpg;

import rpg.sons.narracao.Narracao;
import rpg.LeitorDeArquivosTxt;
import rpg.personagens.BasePersonagens;
import rpg.personagens.inimigos.SoldadoDaDitadura;
import rpg.telas.TelaCombate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Narracao narracao = new Narracao();
            narracao.tocarNarracao(); // toca a voz

            LeitorDeArquivosTxt introducao = new LeitorDeArquivosTxt("Introducao.txt");
            introducao.lerArquivo(); // mostra o texto da história (letra por letra)

            LeitorDeArquivosTxt A1P1 = new LeitorDeArquivosTxt("A1P1.txt");
            A1P1.lerArquivo();

            Scanner input = new Scanner(System.in);
            int o;
            System.out.println("escolha sua classe:\n" +
                    "1-Deejay, 2-Funkeiro, 3-Gospeiro, 4-Jazzista, 5-Metaleiro, 6-Rapper, 7-Pop Star, 8-Roqueiro, 9-Sambista");
            o = input.nextInt();
            switch (o){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
            }


            // 3️⃣ Cria personagens (usando sua BasePersonagens e SoldadoDaDitadura)
            BasePersonagens heroi = new BasePersonagens("Herói", 100, 20, 10, 1){};
            BasePersonagens inimigo = new SoldadoDaDitadura("Soldado da Ditadura");

            // 4️⃣ Inicia a tela de combate no terminal
            TelaCombate tela = new TelaCombate(heroi, inimigo);
            tela.exibirTelaCombate();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
