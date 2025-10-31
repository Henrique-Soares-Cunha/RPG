package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;


public class Sambista extends BasePersonagens {
    public Sambista(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.nome = nome;
        this.pontosVida = 10;
        this.ataque = 3;
        this.defesa = 3;
        this.nivel = 1;
    }

    /** Habilidade: Surdo Viciante, aumenta a própria defesa
     @param inimigo
     */

    public void habilidadeEspecial(BasePersonagens inimigo) throws Exception {
        System.out.println("Sambista toca seu Surdo Viciante!");


        int aumentoDef = Dados.D6();
        int novaDefesa = this.getDefesa() + aumentoDef;

        if (novaDefesa > 20)
            novaDefesa = 20;

        this.setDefesa(novaDefesa);

        System.out.println("O som contagia o campo de batalha!");
        System.out.println("Defesa aumentada em +" + aumentoDef + ".");

    }

}
