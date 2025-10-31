package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;

//Gospeiro tem a habilidade de curar ele mesmo: Luz divina

public class Gospeiro extends BasePersonagens {
    public Gospeiro(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.setNome(nome);
        this.setPontosVida(8);
        this.setAtaque(2);
        this.setDefesa(1);
        this.setNivel(1);
    }

    public void habilidadeEspecial(BasePersonagens inimigo) throws Exception{
        System.out.println("Gospeiro conjura a luz divina");
        int cura = 5 + Dados.D12();
        if (cura > 8) cura = 8;

        this.addVida(cura);
        System.out.println("O " + this.getNome() + "curou " + cura + " de vida.");
    }
}
