package Java;
/*
Desenvolva um programa em Java que leia dois números inteiros do usuário 
e exiba o resultado das operações básicas (adição, subtração, multiplicação, divisão e módulo).
Utilize Scanner para entrada de dados e trate possíveis exceções com try/catch.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuestaoUm {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
//
        try {
            System.out.println("Digite o primeiro número: ");
            int numeroUm = entrada.nextInt();
            System.out.println("Digite o segundo número: ");
            int numeroDois = entrada.nextInt();

            int soma = numeroUm + numeroDois;
            int diminui = numeroUm - numeroDois;
            int mult = numeroUm * numeroDois;
            double div = 0;
            int mod = 0;
            try {
                div = numeroUm / numeroDois;
                mod = numeroUm % numeroDois;
            } catch (ArithmeticException e) {
                System.out.println("Não existem divisões por Zero!");
            }
            System.out.println("O resultado da soma é: " + soma);
            System.out.println("O resultado da subtração é: " + diminui);
            System.out.println("O resultado da multiplicação é: " + mult);
            System.out.println("O resultado da divisão é: " + div);
            System.out.println("O resultado do módulo é: " + mod);
        } catch (InputMismatchException e) {
            System.out.println("Valores não informados corretamente!");
        }
        entrada.close();
        
    }
}