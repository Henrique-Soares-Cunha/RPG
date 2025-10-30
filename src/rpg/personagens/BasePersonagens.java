package rpg.personagens;

import rpg.itens.Inventario;

public abstract class BasePersonagens {
    protected String nome;
    protected int pontosVida;
    protected int vidaMaxima;
    protected int ataque;
    protected int ataquePadrao;
    protected int defesa;
    protected int defesaPadrao;
    protected int nivel;
    protected Inventario inventario;


    public BasePersonagens (String nome, int pontosVida, int ataque, int defesa, int nivel) throws Exception {

    this.setNome(nome);
    this.setAtaque(ataque);
    this.vidaMaxima = pontosVida;
    this.setDefesa(defesa);
    this.defesaPadrao = defesa;
    this.setNivel(nivel);
    this.setPontosVida(pontosVida);
    this.ataquePadrao = ataque;

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
            this.vidaMaxima = pontosVida;
            throw new Exception("O personagem"+this.nome+"morreu");}
        this.pontosVida = pontosVida;
    }
    public void setAtaque(int ataque)throws Exception{
        if (ataque <= 0){throw new Exception("Ataque 0");}
        this.ataque = ataque;
        this.ataquePadrao = ataque;
    }
    public void setDefesa(int defesa)throws Exception{
        if (defesa <= 0){throw new Exception("Defesa 0");}
        this.defesa = defesa;
        this.defesaPadrao = defesa;
    }
    public void setNivel(int nivel)throws Exception{
        if (nivel <= 0){throw new Exception("Nível negativo impossível");}
        this.nivel = nivel;
    }

    /** Distribuir pontos
     * pega a onde ele deseja distribuir pontos e os adiciona nos atributos.
     * @param pontosAtaque: a quantidade de pontos a ser adicionada no ataque.
     * @param pontosDefesa: a quantidade de pontos a ser adicionados na defesa.
     * @param pontosVida: a quantidade de pontos a serem adicionados na vida.
     */
    public void DistribuirPontos(int pontosAtaque , int pontosDefesa, int pontosVida) throws Exception {
        this.addNivel();
        if (pontosAtaque > 0) this.addAtaque(pontosAtaque); this.ataquePadrao += pontosAtaque;
        if (pontosDefesa > 0) this.addDefesa(pontosDefesa); this.defesaPadrao += pontosDefesa;
        if (pontosVida > 0) this.addVida(pontosVida);this.vidaMaxima+=pontosVida;
    }

    /**Re arrumar atributos
     * Ao final do combate os atributos voltam ao padrão
     */
    public void FimCombate(){
        this.ataque = this.ataquePadrao;
        this.defesa = this.defesaPadrao;
        this.pontosVida = this.vidaMaxima;
    }


    //manipular atributos int
    public int addVida(int vida){
        if (-this.pontosVida <= vida){
            this.pontosVida = 0;
            return 0;
        }
        this.pontosVida += vida;
        return this.pontosVida;
    }
    public int addNivel(){
        return ++this.nivel;
    }
    public int addDefesa(int defesa){
         this.defesa += defesa;
         return this.defesa;
    }
    public int addAtaque(int ataque){
        this.ataque += ataque;
        return this.ataque;
    }
}

