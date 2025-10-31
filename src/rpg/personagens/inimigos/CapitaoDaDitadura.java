package rpg.personagens.inimigos;

// Habilidade: Fuzil Zharkoniano
public class CapitaoDaDitadura extends Monstros{
    public CapitaoDaDitadura(String nome,int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome,pontosVida,ataque,defesa,nivel);
        this.setNome(nome);
        this.setAtaque(5);
        this.setDefesa(2);
        this.setPontosVida(15);
        this.setNivel(3);
    }
}
