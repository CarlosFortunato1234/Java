package Java;
/*Questão 2: Busca de Valores em um Array
Crie um programa que leia 10 números inteiros e armazene-os em um array. Em seguida, solicite outro número ao
usuário e informe se ele está presente no array. Caso esteja, exiba todas as posições em que foi encontrado;
caso contrário, informe que o número não foi localizado.
O programa deve utilizar um laço for para preencher e percorrer o array. A entrada dos números deve ser
protegida por try/catch, e a comparação deve ser realizada com operadores relacionais e if/else.
*/
 
import java.util.Scanner;
import java.util.InputMismatchException;
 
public class Questao2_vetor {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
 
        System.out.println("====== Bem-vindo ao programa para ler seus números! =======");
        System.out.println("Digite 10 números inteiros sucessivamente");
        System.out.println("Iremos buscar um número específico dentro desse conjunto.");
        System.out.println("Vamos começar!\n");
 
        int[] numeros = new int[10];
 
        for (int i = 0; i < 10; i++) {
            boolean valorValido = false;
 
            while (!valorValido) {
                try {
                    System.out.print("Informe o número " + (i + 1) + " de 10: ");
                    numeros[i] = leitor.nextInt();
                    valorValido = true;
 
                } catch (InputMismatchException e) {
                    System.out.println("Erro: isso não é um número. Tente novamente.");
                    leitor.next();
                }
            }
        }
 
        System.out.println("\nAgora vamos buscar um número dentro do array.");
        int numeroBuscando = 0;
        boolean valorValido = false;
 
        while (!valorValido) {
            try {
                System.out.print("Digite um número para buscar no array: ");
                numeroBuscando = leitor.nextInt();
                valorValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: isso não é um número. Tente novamente.");
                leitor.next();
            }
        }
 
        boolean encontrado = false;
        System.out.println("\nResultado da busca:");
 
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroBuscando) {
               System.out.println("Número encontrado na posição " + (i + 1));
                encontrado = true;
            }
        }
 
        if (encontrado) {
            System.out.println("\nO número " + numeroBuscando + " foi localizado no array.");
        } else {
            System.out.println("\nO número " + numeroBuscando + " não foi localizado no array.");
        }
    }
}