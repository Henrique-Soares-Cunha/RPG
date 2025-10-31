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
        var itens = personagem.getInventario().listarItensOrdenados();
        for (Itens atual : itens) {
            if (!atual.getNome().equalsIgnoreCase(item.getNome())) continue;

            String efeito = atual.getEfeito() == null ? "" : atual.getEfeito().toLowerCase().trim();

            switch (efeito) {
                case "defesa": {
                    int buff = Dados.D4();
                    personagem.addDefesa(buff);
                    System.out.println(personagem.getNome() + " usa " + atual.getNome() + " e ganha +" + buff + " de DEF.");
                    break;
                }
                case "ataque": {
                    int buff = Dados.D4();
                    personagem.addAtaque(buff);
                    System.out.println(personagem.getNome() + " usa " + atual.getNome() + " e ganha +" + buff + " de ATK.");
                    break;
                }
                case "cura": {
                    int cura = Dados.D6() + 2;
                    personagem.addVida(cura);
                    System.out.println(personagem.getNome() + " usa " + atual.getNome() + " e cura " + cura + " de vida.");
                    break;
                }
                case "dano": {
                    if (inimigo == null) {
                        System.out.println("Não há inimigo para receber o dano deste item.");
                        return;
                    }
                    int dano = Dados.D10() + Dados.D6();
                    inimigo.subtraiVida(dano);
                    System.out.println(personagem.getNome() + " usa " + atual.getNome() + "!");
                    System.out.println("A onda sonora atinge " + inimigo.getNome() + " causando " + dano + " de dano!");
                    break;
                }
                default:
                    System.out.println("Efeito desconhecido para o item: " + atual.getEfeito());
                    return;
            }
            atual.setQuantidade(atual.getQuantidade() - 1);
            if (atual.getQuantidade() <= 0) {
                personagem.getInventario().removerItem(atual.getNome(), 1);
            }
            return;
        }

        System.out.println("Item não encontrado no inventário!");
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
