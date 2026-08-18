import java.util.InputMismatchException;
import java.util.Scanner;

public class Questao_2vet {

    public static void main(String[] args) {

        Scanner Entradauser = new Scanner(System.in);

        System.out.println("Separação de números parese ímpares!");

        try {

            int[] numeros = new int[15];

            int qtdPar = 0;
            int qtdImpar = 0;

            for (int i = 0; i < numeros.length; i++) {

                System.out.println("Digite o valor do " + (i + 1) + "º número:");
                numeros[i] = Entradauser.nextInt();
            }

            System.out.println("\nNúmeros pares:");

            for (int i = 0; i < numeros.length; i++) {

                if (numeros[i] % 2 == 0) {

                    System.out.println(numeros[i]);
                    qtdPar++;

                }
            }

            System.out.println("\nNúmeros ímpares:");

            for (int i = 0; i < numeros.length; i++) {

                if (numeros[i] % 2 != 0) {

                    System.out.println(numeros[i]);
                    qtdImpar++;

                }
            }

            System.out.println("\nQuantidade de números pares: " + qtdPar);
            System.out.println("Quantidade de números ímpares: " + qtdImpar);

        } catch (InputMismatchException e) {

            System.out.println("Erro: digite apenas números inteiros válidos.");

        }

        Entradauser.close();
    }
}