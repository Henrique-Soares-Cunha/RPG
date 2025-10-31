package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;

// Habilidade: Brilho das estrelas

public class PopStar extends BasePersonagens {
    public PopStar (String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception{
        super (nome, pontosVida, ataque, defesa, nivel);
        this.nome = nome;
        this.pontosVida = 12;
        this.ataque = 2;
        this.defesa = 5;
        this.nivel = 1;
    }

    /** Brilho das estrelas da um debuff na defesa do inimigo
     *
     * @param inimigo
     */
    public void habilidadeEspecial(BasePersonagens inimigo) throws Exception {
        System.out.println("Pop Star brilha intensamente!");

        int dano = this.getAtaque() + Dados.D4();
        int novaVidaInimigo = inimigo.getPontosVida() - dano;
        if (novaVidaInimigo < 0)
            novaVidaInimigo = 0;
        inimigo.setPontosVida(novaVidaInimigo);

        int reducaoDef = Dados.D4();
        int novaDefesa = inimigo.getDefesa() - reducaoDef;
        if (novaDefesa < 0)
            novaDefesa = 0;
        inimigo.setDefesa(novaDefesa);


        System.out.println("PopStar causa " + dano + " de dano.");
        System.out.println("Defesa do " + inimigo.getNome() + " foi reduzida em " + reducaoDef + ".");
    }
}
