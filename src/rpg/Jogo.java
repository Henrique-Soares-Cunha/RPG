package rpg;

import rpg.Dados;
import rpg.personagens.BasePersonagens;
import rpg.itens.Inventario;
import rpg.itens.Itens;

import java.util.List;
import java.util.Scanner;

public class Jogo {
    private static final Scanner scanner = new Scanner(System.in);
    public static int Explorar(){
        int dado = Dados.D12();
        if (dado == 1){
            System.out.println("Voce se ferrou caiu em uma armadilha");
            System.out.println("voce vai enfrentar um inimigo");
            return 0;
        }
        if(dado >= 2 && dado <= 3){
            System.out.println("Voce encontrou um inimigo");
            return 1;
        }
        if (dado >=4 && dado <= 8){
            System.out.println("Voce não achou nada");
            return 2;
        }
        if (dado >= 9 && dado <= 10){
            System.out.println("Voce encontrou um item");
            return 3;
        }
        if (dado >= 11 && dado <= 12){
            System.out.println("Voce encontrou um ótimo item");
            return 4;
        }
        return 100;
    }

    public static void usarItem(BasePersonagens personagem, BasePersonagens inimigo, Itens item) throws Exception {
        List<Itens> itens = personagem.getInventario().listarItensOrdenados();
        boolean encontrado = false;

        for (int i = 0; i < itens.size(); i++) {
            Itens atual = itens.get(i);

            if (atual.getNome().equals(item.getNome())) {
                encontrado = true;

                int dano = Dados.D10() + Dados.D6();
                inimigo.subtraiVida(dano);

                System.out.println(personagem.getNome() + " usa a Guitarra Harmônica!");
                System.out.println("Uma onda sonora corta o ar e atinge " + inimigo.getNome() + " causando " + dano + " de dano!");

                // diminui quantidade
                atual.setQuantidade(atual.getQuantidade() - 1);
                if (atual.getQuantidade() <= 0) {
                    personagem.getInventario().removerItem(atual.getNome(), 1);
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Item não encontrado no inventário!");
        }
    }


    public static void fugir(BasePersonagens personagem) throws Exception{
        int valor = Dados.D20();
        if (valor <= 14){
            System.out.println("Você falhou em fugir e tomou um ataque de oportunidade");
            personagem.subtraiVida((int) (Dados.D4()));
        }
        else{
            System.out.println("Voce fugiu");
        }
    }
    public static boolean decisao(){
        int valor = scanner.nextInt();
        if (valor == 1){
            return true;
        }
        return false;
    }
}
