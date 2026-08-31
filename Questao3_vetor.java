/* # Questão 3: Separação de Números Pares e Ímpares
Desenvolva um programa que leia 15 números inteiros e
 armazene-os em um array. Depois, percorra o array
e exiba separadamente os números pares e os números 
ímpares.
Ao final, informe a quantidade de elementos de cada grupo.
Utilize o operador módulo (%) para identificar a paridade. O preenchimento do array 
deve ser feito com for, e o programa deve tratar entradas inválidas usando try/catch. */
import java.util.InputMismatchException;
import java.util.Scanner;


public class Questao3_vetor {
    public static void main(String[] args) {

        Scanner Entradauser = new Scanner(System.in);

 try {

    System.out.println("Separador de números pares e ímpares");
    System.out.println("Insira 15 números, o programa irá separar os ímpares e os pares.");

    int[] validanumeros = new int[15];
    int par = 0;
    int impar = 0;

    for (int i = 0; i < 15; i++) {
        System.out.println("Digite o " + (i + 1) + "º número:");
        validanumeros[i] = Entradauser.nextInt();

    }
    System.out.println("\nNúmeros pares:");
    for (int i = 0; i < 15; i++) {
       
        if (validanumeros[i] % 2 == 0) {
            System.out.println( validanumeros[i]);
            par++;
        }

    }
   System.out.println("\nNúmeros ímpares:");
    for (int i = 0; i < 15; i++) {

        if (validanumeros[i] % 2 != 0) {
              System.out.println( validanumeros[i]);
              impar++;
        }

    }
      System.out.println("\nQuantidade de números pares: " + par);
       
      System.out.println("Quantidade de números ímpares: " + impar);
}
catch (InputMismatchException e) {

    System.out.println("Digite apenas numeros inteiros!");

}
     Entradauser.close();
        }
    }