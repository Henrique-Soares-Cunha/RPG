package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;

// Habilidade: Visão da rima

public class Rapper extends BasePersonagens {
    public Rapper(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.nome = nome;
        this.pontosVida = 10;
        this.ataque = 3;
        this.defesa = 3;
        this.nivel = 1;
    }
    public void habilidadeEspecial(BasePersonagens inimigo) throws Exception {
        System.out.println(" Rapper dispara a Visao da Rima!");
        int danoVerdadeiro = 8 + Dados.D10();
        int novaVida = inimigo.getPontosVida() - danoVerdadeiro;
        if (novaVida < 0)
            novaVida = 0;
        inimigo.setPontosVida(novaVida);
        System.out.println("Dano verdadeiro: " + danoVerdadeiro + ".");
    }
}
