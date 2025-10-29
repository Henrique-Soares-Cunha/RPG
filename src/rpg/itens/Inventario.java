package rpg.itens;

import java.util.ArrayList;

public class Inventario {
    private ArrayList <Itens> itens;
    private final int capacidadeMaxima;
    
    public Inventario() {
        this.capacidadeMaxima = 3;
        this.itens = new ArrayList<>();
        System.out.println("Inventário criado.");
    }
    public Inventario(Inventario modelo) throws Exception {
        if (modelo == null) throw new Exception("Inventario ausente");
        this.capacidadeMaxima = modelo.capacidadeMaxima;
        this.itens = new ArrayList<>();

        for (int i = 0; i < modelo.itens.size(); i++) {
            Itens itemOriginal = modelo.itens.get(i);
            this.itens.add(new Itens(itemOriginal));
        }
    }

    @Override
    public Object clone()
    {
        Inventario copia = null;
        try
        {
            copia = new Inventario(this);
        }
        catch (Exception erro)
        {
            throw new RuntimeException("Erro ao clonar inventario" + erro.getMessage());
        }
        return copia;
    }


    /** Esse metodo adiciona um novo item e se ja exisitir o item, aumenta a quantidade
     @param novo: Novo item a ser adicionado
     @since 1.0
     */
    public void adicionarItem(Itens novo) throws Exception{
        if (novo == null) throw new Exception ("Item nulo");

        for (int i = 0; i < itens.size(); i++){
            Itens existente = itens.get(i);
            if (existente.equals(novo)){
                int novaQtd = existente.getQuantidade() + novo.getQuantidade();
                existente.setQuantidade(novaQtd);
                return;
            }
        }
    }
}
