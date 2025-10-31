package rpg.personagens.inimigos;

//Habilidade: Pistola Zharkoniana
public class SoldadoDaDitadura extends Monstros{
    public SoldadoDaDitadura(String nome,int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome,pontosVida,ataque,defesa,nivel);
        this.nome = nome;
        this.ataque = 3;
        this.defesa = 2;
        this.pontosVida = 8;
        this.nivel = 1;
    }
}


