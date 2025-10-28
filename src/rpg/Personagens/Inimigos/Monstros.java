package rpg.Personagens.Inimigos;

import rpg.Personagens.BasePersonagens;
import rpg.Dados;

public abstract class Monstros extends BasePersonagens {

    public Monstros(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        setNome(nome);
        setAtaque(ataque);
        setDefesa(defesa);
        setNivel(nivel);
        setPontosVida(pontosVida);
    }

    public int Soco(int ataque){
        return ataque * Dados.D4();
    }
}
