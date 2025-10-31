package rpg.personagens.inimigos;

import rpg.personagens.BasePersonagens;
import rpg.Dados;

public abstract class Monstros extends BasePersonagens {

    public Monstros(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);

        try{
            this.setNome(nome);
            this.setAtaque(ataque);
            this.setDefesa(defesa);
            this.setNivel(nivel);
            this.setPontosVida(pontosVida);

        } catch (Exception e){
            throw e;
        }

    }

    public int soco(){
        return this.ataque * Dados.D4();
    }
    public int facada(){
        return this.ataque * Dados.D6();
    }
    public int tiro(){
        return this.ataque * Dados.D8();
    }
    public int raioLaser(){
        return this.ataque * Dados.D10();
    }
    public int instrumentoProfano(){
        return this.ataque * Dados.Dpersonalizado(5,15);
    }
}

