package rpg.personagens.inimigos;

//Habilidade: Bazooka Zharkoniana
public class GeneralDaDitadura extends Monstros{
    public GeneralDaDitadura(String nome,int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome,pontosVida,ataque,defesa,nivel);
        this.nome = nome;
        this.ataque = 5;
        this.defesa = 2;
        this.pontosVida = 20;
        this.nivel = 4;
    }
}
