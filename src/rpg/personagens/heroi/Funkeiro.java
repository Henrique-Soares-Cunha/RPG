package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;

//Funkeiro tem defesa e ataque iguais, habilidade: Passinho mítico

public class Funkeiro extends BasePersonagens {
    public Funkeiro(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.nome = nome;
        this.pontosVida = 13;
        this.ataque = 3;
        this.defesa = 3;
        this.nivel = 1;
    }

    /** Passinho mítico ganha um buff de ataque
     *
     @param inimigo
     */
    public void habilidadeEspecial (BasePersonagens inimigo) throws Exception{
        System.out.println("Funkeiro manda o passinho mitico");
        int dano = this.getAtaque() * Dados.D8();
        int novaVida = inimigo.getPontosVida() - dano;
        if (novaVida < 0) novaVida = 0;
        inimigo.setPontosVida(novaVida);

        int buff = Dados.D4();
        this.setAtaque(this.getAtaque() + buff);
        System.out.println ("Causou " + dano + "de dano e ganhou " + buff + "de ataque");

    }
}
