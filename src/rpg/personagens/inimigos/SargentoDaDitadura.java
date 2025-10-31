package rpg.personagens.inimigos;


public class SargentoDaDitadura extends Monstros{
    public SargentoDaDitadura(String nome,int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome,pontosVida,ataque,defesa,nivel);
        this.setNome(nome);
        this.setAtaque(4);
        this.setDefesa(2);
        this.setPontosVida(10);
        this.setNivel(2);
    }
}