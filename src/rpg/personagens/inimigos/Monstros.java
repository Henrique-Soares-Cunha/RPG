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

    public int Soco(){
        return this.ataque * Dados.D4();
    }
}

