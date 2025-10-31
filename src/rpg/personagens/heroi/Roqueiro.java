package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;

//Habilidade: Solo Estridente
public class Roqueiro extends BasePersonagens {
    public Roqueiro(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.nome = nome;
        this.pontosVida = 12;
        this.ataque = 4;
        this.defesa = 2;
        this.nivel = 1;
    }

    /**
     * Solo estridente: dano em dobro
     * @param inimigo
     */
    public void habilidadeEspecial(BasePersonagens inimigo) throws Exception {
        System.out.println(" Roqueiro executa o Solo Estridente!");
        int base = this.getAtaque() + Dados.D6();
        boolean crit = Dados.D20() >= 18;
        int dano = base;
        if (crit)
            dano = base * 2;

        int novaVida = inimigo.getPontosVida() - dano;
        if (novaVida < 0)
            novaVida = 0;
        inimigo.setPontosVida(novaVida);

        if (crit)
            System.out.println("CRITICO! Dano em dobro!");
        System.out.println("Dano: " + dano + ".");
    }

}
