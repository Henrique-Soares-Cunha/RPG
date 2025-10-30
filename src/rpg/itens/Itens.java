package rpg.itens;

public class Itens implements Comparable<Itens>{
    private String nome;
    private String descricao;
    private int quantidade;
    private String efeito;

    public Itens(String nome, String descricao, int quantidade, String efeito) throws Exception{
        if (nome == null || descricao == null) {
            throw new Exception("Nome ou descrição ausentes");
        }
        if (quantidade < 0){
            throw new Exception("Quantidade negativo");
        }
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.efeito = efeito;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public String getEfeito() {
        return efeito;
    }
    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void addQuantidade(int quantidade){
        this.quantidade =  this.quantidade + quantidade;
        }

    public Itens(Itens modelo) throws Exception{
        if (modelo == null){
            throw new Exception("Item ausente");
        }
        this.nome = modelo.nome;
        this.descricao = modelo.descricao;
        this.quantidade = modelo.quantidade;
        this.efeito = modelo.efeito;
    }


    public String getValorEfeito(){
        switch (this.efeito){
            case "cura":
                return "c1";
            case "grandeCura":
                return "c3";
            case "giganteCura":
                return "c8";
            case "mehoraAtaque":
                return "a1";
            case "grandeMelhoraAtaque":
                return "a2";
            case "giganteMelhoraAtaque":
                return "a4";
            case "melhoraDefesa":
                return "d1";
            case "grandeMelhoraDefesa":
                return "d2";
            case "giganteMelhoraDefesa":
                return "d4";
            default:
                return "";
        }
    }

    @Override
    public String toString(){
        return nome + " (x" + quantidade + ", efeito " + efeito + ")";
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Itens comparacao = (Itens)(obj);
        if (this.nome.compareTo(comparacao.nome) != 0) return false;
        if (this.descricao.compareTo(comparacao.descricao) != 0) return false;
        if (this.efeito.compareTo(comparacao.efeito) != 0) return false;

        return true;
    }
    @Override
    public int hashCode() {
        int ret = 1;
        if (this.nome != null) ret = ret * 2 + this.nome.hashCode();
        if (this.descricao != null) ret = ret * 2 + this.descricao.hashCode();
        ret = ret * 2 + ((Integer) this.quantidade).hashCode();
        if (this.efeito != null) ret = ret * 2 + this.efeito.hashCode();
        if (ret < 0) ret = -ret;
        return ret;
    }




    @Override
    public int compareTo(Itens outroItem){
        if (this == outroItem) return 0;
        if (outroItem == null) return 666;
        if (this.efeito.compareTo(outroItem.efeito) < 0) return -6;
        if (this.efeito.compareTo(outroItem.efeito) == 0) return 0;
        return 6;
    }
}



