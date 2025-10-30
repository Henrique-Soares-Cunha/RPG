package rpg.itens;

import java.util.ArrayList;
import java.util.List;

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

        if (this.itens.size() == 0){
            itens.add(novo);
        }
        else {
            for (int i = 0; i < this.itens.size(); i++) {
                Itens existente = itens.get(i);
                if (existente.equals(novo)) {
                    int novaQtd = existente.getQuantidade() + novo.getQuantidade();
                    existente.setQuantidade(novaQtd);
                    return;
                }

            }
            if (itens.size() >= capacidadeMaxima) throw new Exception("Inventario cheio!");
            this.itens.add(novo);
        }
    }

    /** Esse metodo remove quantidade de um item, se chegar a 0, remove da lista
     @param nome: Nome do item
     @param qtd: Quantidade do item
     @since 1.0
     */

    public boolean removerItem (String nome, int qtd) throws Exception {
        if (nome == null || qtd <= 0) return false;

        for (int i = 0; i < itens.size(); i++){
            Itens item = itens.get(i);
            if (item.getNome().equals(nome)){
                int novaQtd = item.getQuantidade() - qtd;
                if (novaQtd > 0){
                    item.setQuantidade(novaQtd);
                }
                else{
                    itens.remove(i);
                }
                return true;
            }
        }
        return false;
    }

    /** Esse metodo ordenada itens do inventario por quantidade (crescente)
     @since 1.0
    */

    public List<Itens> listarItensOrdenados(){
        List<Itens> ordenados = new ArrayList<>(itens);
        for (int i = 0; i < ordenados.size() - 1; i++){
            for (int j = 0; j < ordenados.size() - i - 1; j++){
                Itens atual = ordenados.get(j);
                Itens proximo = ordenados.get(j + 1);

                if (atual.getQuantidade() > proximo.getQuantidade()){
                    ordenados.set(j, proximo);
                    ordenados.set(j + 1, atual);
                }
            }
        }
        return ordenados;
    }

    /** Esse metodo mostra o inventario formatado no terminal
     @since 1.0
     */
    public void mostrarInventario(){
        System.out.println("- - - Inventario - - -");
        List <Itens> ordem = this.listarItensOrdenados();
        for (int i = 0; i < ordem.size(); i++){
            System.out.println(ordem.get(i));
        }
    }

    /** Esse metodo retorna quantidade total (soma das quantidades)
     @since 1.0
     */

    public int totalItens(){
        int soma = 0;
        for (int i = 0; i < itens.size(); i++){
            soma += itens.get(i).getQuantidade();
        }
        return soma;
    }

    /** Esse metodo copia parte dos itens de outro inventario (drop de inimigo)
     @param origem
     @param fracao
     @since 1.0
     */

    public void dropInimigo (Inventario origem, double fracao) throws Exception{
        if (origem == null || fracao <= 0) throw new Exception ("Sem drop");
        for (int i = 0; i < origem.itens.size(); i++){
            Itens item = origem.itens.get(i);
            int pegar = (int) (item.getQuantidade() * fracao);

            if (pegar <= 0 && item.getQuantidade() > 0){
                pegar = 1;
            }

            adicionarItem(new Itens (item.getNome(), item.getDescricao(), pegar, item.getEfeito()));
        }
    }
}
