package Java;
/*# Questão 6: Controle de Estoque com HashMap
Desenvolva um sistema simples de estoque utilizando um HashMap<String, Integer>,
no qual a chave representa o nome do produto e o valor representa a quantidade disponível.
O menu deve oferecer as opções de cadastrar produto, consultar estoque, atualizar quantidade, 
remover produto e listar todos os produtos.
Utilize switch para as opções do menu e um laço while ou 
do/while para manter o sistema em execução. Ao consultar 
ou atualizar um produto, verifique sua existência com if/else.
 Trate entradas numéricas inválidas com try/catch e faça as conversões necessárias. */
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Questao6_vetor {
    public static void main(String[] args) {

        Scanner Entradauser = new Scanner(System.in);
        HashMap<String, Integer> estoque = new HashMap<>();
        

        boolean continuar = true; 

        try {
            System.out.println("Bem vindo ao sistema simples de gerenciamento de Estoque!");    
            while (continuar) {
            System.out.println("========MENU==========="); 
            System.out.println("Opção 1: Cadastrar produtos");   
            System.out.println("Opção 2: Consultar estoque.");   
            System.out.println("Opção 3: Atualizar quantidade");
            System.out.println("Opção 4: Remover produto");
            System.out.println("Opção 5: Listar todos os produtos");
            System.out.println("Opção 6: Sair");
      
            System.out.println("\n\n");

            System.out.println("Escolha uma opção: ");
            int opcao = Entradauser.nextInt();
          
           //
            	switch(opcao) {
		case 1: {
            System.out.println("Digite o nome do produto:");
            Entradauser.nextLine();
            String nomeProduto = Entradauser.nextLine();

          System.out.println("Digite a quantidade");
             int quantidade = Entradauser.nextInt();

             if (estoque.containsKey(nomeProduto)) {
                System.out.println("Esse produto já está cadastrado!");

             } else {
                estoque.put(nomeProduto, quantidade);
                System.out.println("Produto cadastrado!");
             }
            break; 
        }

        case 2: { 
            System.out.println("Digite o nome do produto:");
         Entradauser.nextLine();
         String nomePesquisa = Entradauser.nextLine();

         if(estoque.containsKey(nomePesquisa)) {
            System.out.println("Produto:" + nomePesquisa);
            System.out.println("Quantidade " + estoque.get(nomePesquisa));
         } else {
            System.out.println("Produto não encontrado");
         }
            
            break; 
        }

        case 3: {
              System.out.println("Digite o nome do produto que deseja atualizar: ");

              Entradauser.nextLine();
              String nomePesquisa = Entradauser.nextLine();

              
              if (estoque.containsKey(nomePesquisa)) {
                System.out.println("Digite a nova quantidade:");
                int novaQTD = Entradauser.nextInt();

                estoque.put(nomePesquisa, novaQTD);
                System.out.println("Quantidade atualizada!");
            
              } else {
                System.err.println("Produto não encontrado. ");
              }
            
              break;
        }
            
        case 4: {
              System.out.println("Digite o produto que você deseja remover: ");
              Entradauser.nextLine();
              String nomeProduto = Entradauser.nextLine();

              if (estoque.containsKey (nomeProduto)) {
                estoque.remove(nomeProduto);
                System.err.println("Produto Removido");
              } else {
                System.out.println("Produto não encontrado.");
              }
        }

          case 5: { 
            System.out.println("===============PRODUTOS===============");
             for (String produto : estoque.keySet()) {
                System.out.println( 
                 "Produto: " + produto + " | Quantidade "  + estoque.get(produto)
                );
             }
            break;
        }

        case 6: { 
            System.out.println("Encerrando o programa.");
             continuar = false; 
            break;
        }
        default: {
    System.out.println("Opção inválida!");
               break;
        }


                } // fecha chaves do switch
            }
           } // fecha o try

          catch (InputMismatchException e) {
    System.out.println("Erro: digite apenas valores numéricos válidos.");
}

Entradauser.close();
            
         Entradauser.close();

    }
}

