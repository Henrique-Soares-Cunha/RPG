package Personagens.Inimigos;

import Personagens.BasePersonagens;

public abstract class Monstros extends BasePersonagens {

    public Monstros(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
    }
}
