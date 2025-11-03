package rpg;

import java.util.Scanner;
import rpg.itens.Itens;
import rpg.personagens.BasePersonagens;

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
        if (dado == 11){
            System.out.println("Voce encontrou um ótimo item");
            return 4;
        }
        if (dado == 12){
            System.out.println("Voce encontrou um item de cura");
            return 5;
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
    public static int fugir(BasePersonagens personagem){
        int valor = Dados.D20();
        if (valor <= 18){
            System.out.println("você falhou em fugir e tomou um ataque de oportunidade");
            personagem.subtraiVida((int) (Dados.D6()));
            return 1;
        }
        System.out.println("Voce fugiu");
        return 0;
    }
    public static boolean decisao(){
        int valor = scanner.nextInt();
        if (valor == 1){
            return true;
        }
        return false;
    }
    public static void finalizarAto(BasePersonagens heroi) throws Exception {
        Scanner input = new Scanner(System.in);
        heroi.FimAto();
        int ataque = 0 , defesa = 0, vida = 0 , teste;
        for (int i = 0 ; i < 3 ; i++){
            System.out.println("Você subiu de nivel vc quer seus pontos em: 1-ataque 2-defesa 3-vida");
            teste = input.nextInt();
            switch (teste){
                case 1:
                    ataque += 1;
                    break;
                case 2:
                    defesa += 1;
                    break;
                case 3:
                    vida += 1;
                    break;
                default:
                    System.out.println("Opção invalida");
                    i --;
                    break;
            }
        }
        heroi.DistribuirPontos(ataque, defesa, vida);
    }
}
