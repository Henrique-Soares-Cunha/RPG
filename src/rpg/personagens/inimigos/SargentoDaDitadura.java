package rpg.personagens.inimigos;

//Habilidade: Espingarda Zharkoniana
public class SargentoDaDitadura extends Monstros{
    public SargentoDaDitadura(String nome,int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome,pontosVida,ataque,defesa,nivel);
        this.nome = nome;
        this.ataque = 4;
        this.defesa = 2;
        this.pontosVida = 10;
        this.nivel = 2;
    }
}