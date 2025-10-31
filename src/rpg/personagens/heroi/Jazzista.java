package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;

//Jazzista tera a habilidade: Ritmo Contagiante
public class Jazzista extends BasePersonagens {
    public Jazzista(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.setNome(nome);
        this.setPontosVida(10);
        this.setAtaque(3);
        this.setDefesa(2);
        this.setNivel(1);
    }

    /** Esse metodo implementa a habilidade especial do jazzista: ritmo contagiante, um dano crítico
     * @param inimigo
     */
    public void habilidadeEspecial(BasePersonagens inimigo) throws Exception{
        System.out.println ("Jazzista toca um ritmo contagiante");
        int base = Dados.D6();
        int critico = 0;
        if (Dados.D20() >= 15){
            critico = Dados.D8();
        }
        int dano = base + critico;

        System.out.println("Dano: " + dano);

        inimigo.subtraiVida(dano);

        if (critico > 0){
                System.out.println ("O ritmo foi muito contagiante para o " + inimigo.getNome() + " Bonus de dano: " + critico);
            System.out.println("Dano total: " + dano);
            System.out.println("Vida atual de: " + inimigo.getNome() + ": " + inimigo.getPontosVida());
        }
    }
}
