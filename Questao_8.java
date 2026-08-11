/*# Questão 8: Contagem de Dígitos com for

Crie um programa que leia um número inteiro positivo e conte quantos dígitos ele possui.
Utilize um laço for com conversão de String, operadores relacionais e try/catch para validação de entrada.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Questao_8 {

    public static void main(String[] args) {

        Scanner Entradauser = new Scanner(System.in);

        try {
           System.out.println("Bem vindo ao leitor de números inteiros positivos! ");
        System.out.println("Digite um número inteiro positivo: ");

            int numero = Entradauser.nextInt();

            if (numero > 0) {

                int contador = 0;

               //não deu tempo de terminar