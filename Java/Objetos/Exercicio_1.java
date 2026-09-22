package Objetos;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

 
public class Exercicio_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        int opt = -1;
        do {
            System.out.println("==== REVENDA ====");
            System.out.println("0. Sair");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Vender Produto");
            System.out.println("3. Entrada de Produto");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Mostrar valor total em estoque");
            System.out.println("Digite a operação: ");
            opt = buscarOperacao(s);
            switch (opt) { 
                case 0:
                    System.out.println("Tchau!");
                    break;
                case 1:
                    System.out.println("Digite o nome do produto: ");
                    String nome = s.nextLine();
                    System.out.println("Digite o preço do produto");
                    double preco = s.nextDouble();
                    System.out.println("Digite a quantidade do produto: ");
                    int quantidade = s.nextInt();
                    Produto produto = new Produto (
                      nome,
                      preco,
                      quantidade
                    );
                    produtos.add(produto);
                    break;
                case 2:
                    System.out.println("Digite o nome do produto: ");
                    String nomeVenda = s.next();

                    System.out.println("Digite a quantidade que está sendo vendida: ");
                    int quantidadeVenda = s.nextInt();

                    for (Produto produtoVenda : produtos) {
                        if (produtoVenda.nome.equals(nomeVenda)) {
                             produtoVenda.removerEstoque(quantidadeVenda);
                               System.out.println("Venda realizada com sucesso!");
                        }
                    }
                    break;

                 case 3:
                    System.out.println("Digite o nome do produto: ");
                    String nomeCompra = s.next();

                    System.out.println("Digite a quantidade que está sendo realizada a entrada: ");
                    int quantidadeCompra = s.nextInt();

                    for (Produto produtoCompra : produtos) {
                        if (produtoCompra.nome.equals(nomeCompra)) {
                             produtoCompra.adicionarEstoque(quantidadeCompra);
                               System.out.println("Compra realizada com sucesso!");
                        }
                    }

                    break;


                case 4:
                    for(Produto p : produtos) {
            
                        p.exibirDados();

                    }
                    break;

                case 5: 
                 double valorTotal = 0; 

                 for (Produto p : produtos) {
        valorTotal += p.calcularValorEstoque();
                }
                System.out.println("Valor total armazenado no estoque: R$ " + valorTotal);
                break; 

                  default:
                    System.out.println("Operação inválida.");
                    break;

            }
        } while (opt != 0);
        s.close();
    }
 
    public static int buscarOperacao(Scanner s) {
        int opt = -1;
        do {
            try {
                opt = s.nextInt();
            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Operação inválida");
                System.out.println("Digite novamente a informação!");
                opt = -1;
            }
        } while (opt < 0);
 
        return opt;
    }
}
 