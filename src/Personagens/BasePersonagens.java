package Personagens;

import Itens.Inventario;

public abstract class BasePersonagens {
    protected String nome;
    protected int pontosVida;
    protected int ataque;
    protected int defesa;
    protected int nivel;
    protected Inventario inventario;


    public BasePersonagens (String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception{
    super();
        if (nome == null){
        throw new Exception("Nome do personagem nao pode ser vazio");
    }
    if (pontosVida <= 0){
        throw new Exception ("Pontos de vida (HP) devem ser maiores que zero");
    }
    if (ataque < 0){
        throw new Exception ("O valor do ataque nao pode ser negativo");
    }
    if (defesa < 0){
        throw new Exception ("O valor da defesa nao pode ser negativo");
    }
    if (nivel <= 0){
        throw new Exception ("O valor do nivel nao pode ser negativo");
    }
    this.nome = nome;
    this.pontosVida = pontosVida;
    this.ataque = ataque;
    this.defesa = defesa;
    this.nivel = nivel;
    this.inventario = new Inventario();
    }

}

