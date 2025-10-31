package rpg.personagens.inimigos;


public class GeneralDaDitadura extends Monstros{
    public GeneralDaDitadura(String nome,int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome,pontosVida,ataque,defesa,nivel);
        this.setNome(nome);
        this.setAtaque(5);
        this.setDefesa(2);
        this.setPontosVida(20);
        this.setNivel(4);
    }
}
