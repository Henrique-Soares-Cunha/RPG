package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;



public class Metaleiro extends BasePersonagens {
    public Metaleiro(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.setNome(nome);
        this.setPontosVida(13);
        this.setAtaque(3);
        this.setDefesa(1);
        this.setNivel(1);
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

        System.out.println (danoTotal);
        inimigo.subtraiVida(danoTotal);

        int danoReverso = danoD10 / 2;
        System.out.println (danoReverso);
        if (danoReverso < 1) danoReverso = 1;
        this.subtraiVida(danoReverso);

        System.out.println ("Dano causado ao " + inimigo.getNome() + ": " + danoTotal + " (" + danoD12 + "+" + danoD8 + ")");
        System.out.println ("A guitarra maligna fez o metaleiro perder " + danoReverso + " de vida");

    }

}
