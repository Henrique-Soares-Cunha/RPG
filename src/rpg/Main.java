package rpg;

import rpg.itens.Inventario;
import rpg.itens.Itens;
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

             // mostra o texto da história (letra por letra)

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
                default:
                    System.out.println("classe invalida vagabundo nesse caso vc perdeu");
                    break;
            }
            
            // Aqui inicia os testes

            // 3️⃣ Cria personagens (usando sua BasePersonagens e SoldadoDaDitadura)
            BasePersonagens heroi = new BasePersonagens("DeeJay", 100, 20, 10, 1) {};
            BasePersonagens inimigo = new SoldadoDaDitadura("Soldado da Ditadura");

            // 4️⃣ Inicia a tela de combate no terminal
            TelaCombate tela = new TelaCombate(heroi, inimigo);
            tela.exibirTelaCombate();

            // Cria o inventário
            Inventario inv = new Inventario();

            // Cria alguns itens
            Itens espada = new Itens("Espada", "Arma afiada", 1, "Dano alto");
            Itens pocao = new Itens("Poção", "Recupera vida", 3, "Cura");
            Itens escudo = new Itens("Escudo", "Defesa básica", 2, "Defesa");

            System.out.println(espada);
            // Adiciona os itens
            inv.adicionarItem(espada);
            inv.adicionarItem(pocao);
            inv.adicionarItem(escudo);

            // Mostra inventário ordenado por quantidade
            inv.mostrarInventario();

            // Mostra total de itens
            System.out.println("Total de itens: " + inv.totalItens());

            // Remove 1 poção
            inv.removerItem("Poção", 1);

            System.out.println("Após remover 1 poção:");
            inv.mostrarInventario();

            // Testa o clone (cópia do inventário)
            Inventario copia = (Inventario) inv.clone();
            System.out.println("Inventário clonado:");
            copia.mostrarInventario();



        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
