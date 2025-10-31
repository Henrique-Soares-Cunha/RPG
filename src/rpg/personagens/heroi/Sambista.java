package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;


public class Sambista extends BasePersonagens {
    public Sambista(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.setNome(nome);
        this.setPontosVida(10);
        this.setAtaque(3);
        this.setDefesa(2);
        this.setNivel(1);
    }

    /** Habilidade: Surdo Viciante, aumenta a própria defesa
     *@param inimigo
     */

    public void habilidadeEspecial(BasePersonagens inimigo) throws Exception {
        System.out.println("Sambista toca seu Surdo Viciante!");


        int aumentoDef = Dados.D6();
        this.addDefesa(aumentoDef);

        System.out.println("O som contagia o campo de batalha!");
        System.out.println("Defesa de " + this.getNome()+ " aumentou em +" + aumentoDef + ".");
        System.out.println("Defesa atual: " + this.getDefesa());

    }

}
