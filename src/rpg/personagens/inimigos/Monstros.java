package rpg.personagens.inimigos;

import rpg.personagens.BasePersonagens;
import rpg.Dados;

public abstract class Monstros extends BasePersonagens implements Cloneable{

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

    public Monstros(Monstros monstro , String nome) throws Exception {
        super(nome, monstro.getPontosVida() , monstro.getAtaque(), monstro.getDefesa(), monstro.getNivel());

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
        int dano =this.ataque * Dados.D4() / 2;
        System.out.println("Dano: " + dano);
        return dano;
    }
    public int facada(){
        int dano =this.ataque * Dados.D6() / 2;
        System.out.println("Dano: " + dano);
        return dano;
    }
    public int tiro(){
        return this.ataque * Dados.D8() / 2;
    }
    public int raioLaser(){
        return this.ataque * Dados.D10() / 2;
    }
    public int instrumentoProfano(){
        return this.ataque * Dados.DPersonalizado(5,15) / 2;
    }
}

