package rpg.personagens.inimigos;

public class SoldadoDaDitadura extends Monstros{
    public SoldadoDaDitadura(String nome) throws Exception {
        super(nome);
        this.nome = nome;
        this.ataque = 2;
        this.defesa = 2;
        this.pontosVida = 5;
        this.nivel = 1;
    }
}

//Soldado menor vida
