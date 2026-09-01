package Java;
/*# Questão 6: Verificação de Número Par ou Ímpar com do/while

Implemente um programa que utilize um laço do/while para ler números do usuário e 
verificar se são pares ou ímpares. O programa deve continuar até que o usuário digite -1. Utilize o operador módulo (%) 
e try/catch para validação.import java.util.InputMismatchException;
*/

import java.util.InputMismatchException;
import java.util.Scanner;
//
public class Questao_6{

    public static void main(String[] args) {

        Scanner Entradauser = new Scanner(System.in);
        System.out.println("Bem vindo ao verificador de números!");    
        System.out.println("Digite um número, que o programa irá verificar se é par ou impar, caso deseje parar, basta digitar -1");
        System.out.println("\n");        

        try {
           int numero; //variavél
            do{
        System.out.println("Digite um número");    
        numero = Entradauser.nextInt();
        if (numero == -1){
            System.out.println("Parando o programa...");  
        }

        else if (numero % 2 == 0 ) {
            System.out.println("O número é par!");   
            
        }

        else {
            System.out.println("O número é impar!");   
        }

            } while (numero != -1);


        } catch (InputMismatchException e) {
               System.out.println("Erro: digite apenas valores numéricos válidos.");

    }
    Entradauser.close();
}
}