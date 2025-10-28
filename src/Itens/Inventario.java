package Itens;

public class Inventario {
    
    // Você pode adicionar atributos e métodos aqui
    private int capacidadeMaxima;
    
    public Inventario() {
        this.capacidadeMaxima = 10; // Exemplo
        System.out.println("Inventário criado.");
    }
    
    // Método de exemplo
    public void adicionarItem(String item) {
        System.out.println(item + " adicionado ao inventário.");
    }
}
