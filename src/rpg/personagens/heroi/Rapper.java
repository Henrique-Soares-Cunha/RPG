package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;

// Habilidade: Visão da rima

public class Rapper extends BasePersonagens {
    public Rapper(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.setNome(nome);
        this.setPontosVida(10);
        this.setAtaque(3);
        this.setDefesa(3);
        this.setNivel(1);
    }
    public void habilidadeEspecial(BasePersonagens inimigo) throws Exception {
        System.out.println(" Rapper dispara a Visao da Rima!");
        int danoVerdadeiro = 8 + Dados.D10();

        inimigo.subtraiVida(danoVerdadeiro);
        System.out.println("Dano verdadeiro: " + danoVerdadeiro + ".");
        System.out.println("Vida atual de " + inimigo.getNome() + ":" + inimigo.getPontosVida());
    }
}
