package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;

//Funkeiro tem defesa e ataque iguais, habilidade: Passinho mítico

public class Funkeiro extends BasePersonagens {
    public Funkeiro(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.setNome(nome);
        this.setPontosVida(13);
        this.setAtaque(3);
        this.setDefesa(3);
        this.setNivel(1);
    }

    /** Passinho mítico ganha um buff de ataque
     *
     @param inimigo
     */
    public void habilidadeEspecial (BasePersonagens inimigo) throws Exception{
        System.out.println("Funkeiro manda o passinho mitico");
        int dano = this.getAtaque() * Dados.D8();
        inimigo.subtraiVida(dano);

        int buff = Dados.D4();
        inimigo.addAtaque(buff);
        System.out.println ("Causou " + dano + "de dano ao " + inimigo.getNome() + "e ganhou " + buff + "de ataque");

    }
}
