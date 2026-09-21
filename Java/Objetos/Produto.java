package Objetos;
public class Produto { 
    public String nome; 
    public double preco;
    public double quantidade;
    public boolean estoque;

    Produto (String nome, double preco, int quantidade) {
    this.nome = nome;
    this.preco = preco; 
    this.quantidade = quantidade;  
    }

    public void removerEstoque(int quantidade) { 
        this.quantidade -= quantidade;
    }
    
    public void adicionarEstoque(int quantidade) {
        this.quantidade += quantidade;
    }
    public double calcularValorEstoque (){
        return this.preco * this.quantidade; 
    }

    public void exibirDados () {
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço:" + this.preco);
        System.out.println("Quantidade: " + this.quantidade);
    }
}