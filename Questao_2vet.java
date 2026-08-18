import java.util.InputMismatchException;
import java.util.Scanner;

public class Questao_2vet {

    public static void main(String[] args) {

        Scanner Entradauser = new Scanner(System.in);

        System.out.println("Separação de números parese ímpares!");

        try {

            int[] numeros = new int[15]; //essa aqui é minha array com limite de 15 

            int qtdPar = 0;
            int qtdImpar = 0;

            for (int i = 0; i < numeros.length; i++) {

                System.out.println("Digite o valor do " + (i + 1) + "º número:");
                numeros[i] = Entradauser.nextInt(); //entrada do usuário seguindo a lógica do i + 1 pra se referir ao número, pq o indice começa com 0
            }

            System.out.println("\nNúmeros pares:");

            for (int i = 0; i < numeros.length; i++) {

                if (numeros[i] % 2 == 0) { //se o resto da divisão atribuir o vlaor 0, vai entrar para o contador qtdpar.

                    System.out.println(numeros[i]);
                    qtdPar++;

                }
            }

            System.out.println("\nNúmeros ímpares:");

            for (int i = 0; i < numeros.length; i++) {  

                if (numeros[i] % 2 != 0) { //mesma lógicapara os ímpares, mas com a adição do ponto de exclamação ao invés do "==", ou seja, adicionei o operador "diferente de"

                    System.out.println(numeros[i]); 
                    qtdImpar++;   //contador qtdImpar ++

                }
            }

            System.out.println("\nQuantidade de números pares: " + qtdPar); //aq ele chama o qtd de par
            System.out.println("Quantidade de números ímpares: " + qtdImpar); //msm coisa soq para impar

        } catch (InputMismatchException e) {

            System.out.println("Erro: digite apenas números inteiros válidos.");

        }

        Entradauser.close();
    }
}