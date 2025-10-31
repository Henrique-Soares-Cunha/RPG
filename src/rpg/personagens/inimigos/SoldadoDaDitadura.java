package rpg.personagens.inimigos;


public class SoldadoDaDitadura extends Monstros{
    public SoldadoDaDitadura(String nome,int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome,pontosVida,ataque,defesa,nivel);
        this.setNome(nome);
        this.setAtaque(3);
        this.setDefesa(2);
        this.setPontosVida(8);
        this.setNivel(1);
    }
}


