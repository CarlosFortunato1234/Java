/* # Questão 4: Soma de Números com while

Desenvolva um programa que leia números inteiros do usuário em um laço while 
até que ele digite 0 (zero). Ao final, exiba a soma de todos os números digitados. Utilize try/catch para tratar 
entradas inválidas.*/
import java.util.InputMismatchException;
import java.util.Scanner;


public class Questao_4 {
    public static void main(String[] args) {

        Scanner Entradauser = new Scanner(System.in);

     try {
    System.out.println("Bem vindo ao somador de numeros");    
    System.out.println("Some quantos numeros forem necessarios, caso queira parar, basta digitar zero");   

    System.out.println("Digite um numero: ");      
    int numero = Entradauser.nextInt();
    int soma = 0;
    
    while (numero != 0) {
     
        soma = soma + numero; 
                 System.out.println("Digite outro numero: ");
                numero = Entradauser.nextInt();

    }
    System.out.println("A soma total é: " + soma);
    
}   catch (InputMismatchException e) {
            System.out.println("Digite apenas numeros inteiros!");
}
     Entradauser.close();
    }
}

     