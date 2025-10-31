package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;

// Habilidade: Batida hipnótica

public class Deejay extends BasePersonagens {
    public Deejay(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.nome = nome;
        this.pontosVida = 15;
        this.ataque = 3;
        this.defesa = 1;
        this.nivel = 1;
    }

    /** Batida hipnótica reduz o dano do inimigo entre 1 a 6 de ataque
     *
     @param inimigo
     */
    public void habilidadeEspecial (BasePersonagens inimigo) throws Exception{
        System.out.println ("DeeJay usa Batida Hipnotica!");
        int reducao = Dados.D6();
        int novoAtaque = inimigo.getAtaque() - reducao;
        if (novoAtaque < 0) novoAtaque = 0;
        inimigo.setAtaque(novoAtaque);
        System.out.println("Ataque do inimigo reduzido em " + reducao + ".");
    }
}
