package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;

//Habilidade: Solo Estridente
public class Roqueiro extends BasePersonagens {
    public Roqueiro(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.setNome(nome);
        this.setPontosVida(12);
        this.setAtaque(4);
        this.setDefesa(2);
        this.setNivel(1);
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

        inimigo.subtraiVida(dano);

        if (crit)
            System.out.println("CRITICO! Dano em dobro!");
        System.out.println(dano + " de dano causado em " + inimigo.getNome() + ".");
        System.out.println("Vida atual de: " + inimigo.getNome() + ": " + inimigo.getPontosVida());

    }

}
