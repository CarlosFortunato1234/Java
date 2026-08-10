/*# Questão 3: Tabuada com Laço for

Implemente um programa que leia um número inteiro do usuário e exiba a tabuada desse número (de 1 a 10) utilizando um laço for. 
Valide a entrada com try/catch e utilize operadores de multiplicação.
*/

import java.util.InputMismatchException;
import java.util.Scanner;
public class Questao_3 {
    public static void main(String[] args) {

        Scanner Entradauser = new Scanner(System.in);

            try {
            System.out.println("Digite um número: ");
            int numero = Entradauser.nextInt();
        for (int i = 1; i < 11; i++) 
                 System.out.println( numero + "x" + i + "=" + (numero * i));
        
}
 catch (InputMismatchException e){
    System.out.println("Digite apenas números inteiros!");
 }
         Entradauser.close();
}    
    
}
