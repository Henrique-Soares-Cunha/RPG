package rpg.Personagens;

import rpg.Itens.Inventario;

public abstract class BasePersonagens {
    protected String nome;
    protected int pontosVida;
    protected int ataque;
    protected int defesa;
    protected int nivel;
    protected Inventario inventario;


    public BasePersonagens (String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception{
    setNome(nome);
    try {
        setNome(nome);
        setAtaque(ataque);
        setDefesa(defesa);
        setNivel(1);
        setPontosVida(pontosVida);
    }
    catch (Exception e){
        throw e;
    }
    if (inventario == null){throw new Exception("Inventário não pode ser nulo!");}
    this.inventario = new Inventario();
    }

    //getters
    public String getNome(){
        return this.nome;
    }
    public int  getPontosVida() {
        return this.pontosVida;
    }
    public int getAtaque() {
        return this.ataque;
    }
    public int getDefesa() {
        return this.defesa;
    }
    public int getNivel() {
        return this.nivel;
    }
    public Inventario getInventario() {
        return this.inventario;
    }

    //setters
    public void setNome(String nome)throws Exception{
        if  (nome == null){throw new Exception("Nome do personagem nao pode ser vazio");}
        this.nome = nome;
    }
    public void setPontosVida(int pontosVida)throws Exception{
        if (pontosVida <= 0){throw new Exception("Vida 0 personagem morreu");}
        this.pontosVida = pontosVida;
    }
    public void setAtaque(int ataque)throws Exception{
        if (ataque <= 0){throw new Exception("Ataque 0");}
        this.ataque = ataque;
    }
    public void setDefesa(int defesa)throws Exception{
        if (defesa <= 0){throw new Exception("Defesa 0");}
        this.defesa = defesa;
    }
    public void setNivel(int nivel)throws Exception{
        if (nivel <= 0){throw new Exception("Nível negativo impossível");}
    }
}

