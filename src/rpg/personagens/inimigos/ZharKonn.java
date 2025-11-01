package rpg.personagens.inimigos;

public class ZharKonn extends Monstros{
    public ZharKonn(String nome,int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome,pontosVida,ataque,defesa,nivel);
        this.setNome(nome);
        this.setAtaque(10);
        this.setDefesa(10);
        this.setPontosVida(30);
        this.setNivel(5);
    }
}
