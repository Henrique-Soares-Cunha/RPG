package rpg.itens;

public class Itens implements Comparable<Itens>{
    private String Nome;
    private String Descricao;
    private int quanridade;
    private int efeito;

    public Itens(String nome, String descricao, int quanridade, int efeito) throws Exception{
        if (nome == null || descricao == null) {
            throw new Exception("Nome ou descrição ausentes");
        }
        if (quanridade < 0){
            throw new Exception("Quantidade negativo");
        }
        this.Nome = nome;
        this.Descricao = descricao;
        this.quanridade = quanridade;
        this.efeito = efeito;


    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Itens comparacao = (Itens)(obj);
        if (this.Nome != comparacao.Nome) return false;
        if (this.Descricao != comparacao.Descricao) return false;
        if (this.efeito != comparacao.efeito) return false;

        return true;
    }

    @Override
    public int compareTo(Itens outroItem){
        if (this == outroItem) return 0;
        if (outroItem == null) return -666;
        if (this.efeito > outroItem.efeito) return -6;
        if (this.efeito == outroItem.efeito) return 0;
        return 6;
    }
}
