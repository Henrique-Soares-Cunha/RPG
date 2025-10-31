package rpg.personagens.inimigos;

// Habilidade: Fuzil Zharkoniano
public class CapitaoDaDitadura extends Monstros{
    public CapitaoDaDitadura(String nome,int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome,pontosVida,ataque,defesa,nivel);
        this.nome = nome;
        this.ataque = 5;
        this.defesa = 2;
        this.pontosVida = 15;
        this.nivel = 3;
    }
}
