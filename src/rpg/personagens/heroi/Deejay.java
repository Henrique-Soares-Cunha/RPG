package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;

// Habilidade: Batida hipnótica

public class Deejay extends BasePersonagens {
    public Deejay(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.setNome(nome);
        this.setPontosVida(10);
        this.setAtaque(3);
        this.setDefesa(1);
        this.setNivel(1);
    }

    /** Batida hipnótica reduz o dano do inimigo entre 1 a 6 de ataque
     *
     @param inimigo
     */
    public void habilidadeEspecial (BasePersonagens inimigo) throws Exception{
        System.out.println ("DeeJay usa Batida Hipnotica!");
        int reducao = Dados.D6();
        if (inimigo.getAtaque() <= reducao) {inimigo.setAtaque(1); return;}
        inimigo.reducaoAtaque(reducao);
        System.out.println("Ataque do " + inimigo.getNome() + " reduzido em " + reducao + ".");
    }
}
