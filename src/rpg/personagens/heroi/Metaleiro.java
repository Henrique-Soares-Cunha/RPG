package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;



public class Metaleiro extends BasePersonagens {
    public Metaleiro(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.nome = nome;
        this.pontosVida = 18;
        this.ataque = 1;
        this.defesa = 1;
        this.nivel = 1;
    }

    /**Metaleiro tem bastante vida pois ira ter a habilidade Guitarra maligna, onde vai dar bastante dano mas perder uma parte da vida
     *
     * @param inimigo
     */
    public void habilidadeEspecial (BasePersonagens inimigo) throws Exception{
        System.out.println ("O metaleiro joga a Guitarra Maligna e acerta o " + inimigo.getNome() + " em cheio!");

        int danoD12 = Dados.D12();
        int danoD8 = Dados.D8();
        int danoD10 = Dados.D10();
        int danoTotal = danoD12 + danoD8;

        int novaVidaInimigo = inimigo.getPontosVida() - danoTotal;
        if (novaVidaInimigo < 0) novaVidaInimigo = 0;
        inimigo.setPontosVida(novaVidaInimigo);

        int danoReverso = danoD10 / 2;
        int novaVidaMetaleiro = this.getPontosVida() - danoReverso;
        if (novaVidaMetaleiro < 1) novaVidaMetaleiro = 1;
        this.setPontosVida(novaVidaMetaleiro);

        System.out.println ("Dano causado: " + danoTotal + " (" + danoD12 + "+" + danoD8 + ")");
        System.out.println ("A guitarra maligna fez o metaleiro perder " + danoReverso + " de vida");

    }

}
