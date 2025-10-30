package rpg.personagens;

import rpg.itens.Inventario;

public abstract class BasePersonagens {
    protected String nome;
    protected int pontosVida;
    protected int ataque;
    protected int defesa;
    protected int nivel;
    protected Inventario inventario;


    public BasePersonagens (String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {

    this.setNome(nome);
    this.setAtaque(ataque);
    this.setDefesa(defesa);
    this.setNivel(nivel);
    this.setPontosVida(pontosVida);

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
        if (pontosVida <= 0){
            this.pontosVida = pontosVida;
            throw new Exception("O personagem"+this.nome+"morreu");}
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
        this.nivel = nivel;
    }

    //manipular atributos int
    public int addVida(int vida){
        if (this.pontosVida <= vida){
            this.pontosVida = 0;
            return 0;
        }
        this.pontosVida += vida;
        return this.pontosVida;
    }
    public int addNivel(){
        return ++this.nivel;
    }
    public int addDefesa(){
         this.defesa += 5;
         return this.defesa;
    }
    public int addAtaque(){
        this.ataque += 5;
        return this.ataque;
    }
}

