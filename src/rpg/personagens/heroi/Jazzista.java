package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;

//Jazzista tera a habilidade: Ritmo Contagiante
public class Jazzista extends BasePersonagens {
    public Jazzista(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.nome = nome;
        this.pontosVida = 10 ;
        this.ataque = 3;
        this.defesa = 2;
        this.nivel = 1;
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

        int novaVida = inimigo.getPontosVida() - dano;
        if (novaVida < 0) novaVida = 0;
        inimigo.setPontosVida(novaVida);

        if (critico > 0){
                System.out.println ("O ritmo foi muito contagiante para o " + inimigo.getNome() + "Bonus de dano: " + critico);
            System.out.println("Dano total: " + dano);
        }
    }
}
