package Java;
/*# Questão 5: Cadastro de Pessoas sem Nomes Repetidos
Implemente um programa que utilize um HashSet<String> para cadastrar nomes
de pessoas. O programa deve permitir 
inserir nomes, listar todos os nomes cadastrados, 
verificar se determinado nome já foi inserido e 
exibir a quantidade total de pessoas.
Como o HashSet não permite elementos repetidos, 
o programa deve informar ao usuário 
quando ele tentar cadastrar um nome já 
existente. Utilize um menu com switch,
repetição com while e tratamento de erros com try/catch. */
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Questao5_vetor {
    public static void main(String[] args) {

        Scanner Entradauser = new Scanner(System.in);
        HashSet <String> nomes = new HashSet<>();
        

        boolean continuar = true; 

        try {
            System.out.println("Bem vindo ao cadastro único de pessoas!");    
            System.out.println("Realize cadastramento de pessoas, não repita nomes!");   
            System.out.println("");   

            while (continuar) {
            System.out.println("========MENU==========="); 
            System.out.println("Opção 1: Inserir nomes.");   
            System.out.println("Opção 2: Listar todos os nomes cadastrados.");   
            System.out.println("Opção 3: Verificação de nomes cadastrados");
            System.out.println("Opção 4: Exibir quantidade total de pessoas");
            System.out.println("Opção 5: Sair");
      
            System.out.println("\n\n");

            System.out.println("Escolha uma opção: ");
            int opcao = Entradauser.nextInt();
          
           //
            	switch(opcao) {
		case 1: {
            System.out.println("Digite o nome que deseja inserir: ");    
            Entradauser.nextLine();
            String nome = Entradauser.nextLine();
            if (nomes.add(nome)) {
                System.out.println("Nome cadastrado!");
            } else {
                System.out.println("Esse nome já está cadastrado!");
            }
            break; 
        }

        case 2: { 
            System.out.println("Listando todos os nomes... um momento.");
       
            for (String nomeCadastrado : nomes) {
                System.out.println( nomeCadastrado);
            }
            
            break; 
        }

        case 3: {
              System.out.println("Digite o nome que deseja verificar: ");

              Entradauser.nextLine();
              String nomePesquisa = Entradauser.nextLine();

              
              if (nomes.contains(nomePesquisa)) {
                System.out.println("Esse nome já está cadastrado!");
            
              } else {
                System.err.println("Esse nome não está cadastrado.");
              }
            
              break;
        }
            
        case 4: {
              System.out.println("Quantidade total de passoas cadastradas: " + nomes.size ());
              break;
        }

        case 5: { 
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

