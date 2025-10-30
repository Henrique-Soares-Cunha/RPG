package rpg.personagens.heroi;

import rpg.itens.Inventario;
import rpg.personagens.BasePersonagens;

public class Funkeiro extends BasePersonagens {
    public Funkeiro(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.nome = nome;
        this.ataque = 2;
        this.defesa = 2;
        this.pontosVida = 10;
        this.nivel = 1;
    }
}
