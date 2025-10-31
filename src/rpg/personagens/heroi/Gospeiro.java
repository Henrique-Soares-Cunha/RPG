package rpg.personagens.heroi;

import rpg.Dados;
import rpg.personagens.BasePersonagens;

//Gospeiro tem a habilidade de curar ele mesmo: Luz divina

public class Gospeiro extends BasePersonagens {
    public Gospeiro(String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
        this.nome = nome;
        this.pontosVida = 8;
        this.ataque = 2;
        this.defesa = 1;
        this.nivel = 1;
    }

    public void habilidadeEspecial(BasePersonagens inimigo) throws Exception{
        System.out.println("Gospeiro conjura a luz divina");
        int cura = 5 + Dados.D12();
        if (cura > 30) cura = 30;

        this.setPontosVida(this.getPontosVida() + cura);
        System.out.println("Curou " + cura + " de vida.");
    }
}
