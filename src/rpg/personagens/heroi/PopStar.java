package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;

// Habilidade: Brilho das estrelas

public class PopStar extends BasePersonagens {
    public PopStar (String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception{
        super (nome, pontosVida, ataque, defesa, nivel);
        this.setNome(nome);
        this.setPontosVida(12);
        this.setAtaque(2);
        this.setDefesa(5);
        this.setNivel(1);
    }

    /** Brilho das estrelas da um debuff na defesa do inimigo
     *
     * @param inimigo
     */
    public void habilidadeEspecial(BasePersonagens inimigo) throws Exception {
        System.out.println("Pop Star brilha intensamente!");
        int dano = this.ataque / 2 + Dados.D4() * this.ataque;
        int reducaoDef = Dados.D4();

        inimigo.reducaoDefesa(reducaoDef);
        inimigo.subtraiVida(dano);

        System.out.println("PopStar causa " + dano + " de dano.");
        System.out.println("Defesa do " + inimigo.getNome() + " foi reduzida em " + reducaoDef + ".");
    }
}
