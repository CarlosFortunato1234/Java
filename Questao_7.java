package Java;
/*
Desenvolva um programa que converta temperaturas entre Celsius e Fahrenheit.
Ofereça um menu com switch para escolher a conversão desejada. Utilize Scanner para entrada
operadores aritméticos para cálculo e try/catch para tratamento de exceções.
*/

import java.util.InputMismatchException;
import java.util.Scanner;
//
public class Questao_7{

public static void main(String[] args) {

    Scanner Entradauser = new Scanner(System.in);

    try {      
         System.out.println("Bem vindo ao conversor de temperaturas!");    
        System.out.println("Realize a conversões de Celsius e Fahrenheit. Caso queira sair, basta digitar a opção 3");   
        System.out.println("");   
        System.out.println("========MENU==========="); 
        System.out.println("Opção 1: Converter Celsius para Fahrenheit");   
        System.out.println("Opção 2: Converter Fahrenheit para Celsius");   
        System.out.println("Opção 3: Sair!");
        
  
        System.out.println("\n\n");

        System.out.println("Escolha uma opção: ");
        int opcao = Entradauser.nextInt();
       
        switch(opcao) {
    
    case 1: {
        System.out.println("Digite a temperatura em Celsius que você deseja converter: ");    
        double celsius = Entradauser.nextDouble();

        double conversao = ((celsius * 9.0 / 5.0) + 32);
         System.out.println("A temperatura convertida em Fahrenheit fica em torno de: " + conversao + " °F"  );    
        break; 
    }

    case 2: {
        System.out.println("Digite a temperatura em Fahrenheit que você deseja converter: ");    
        double Fahrenheit = Entradauser.nextDouble();

         double conversao2 = ((Fahrenheit - 32) * 5.0 / 9.0);
         System.out.println("A temperatura convertida em Celsius fica em torno de: " + conversao2 + " °C"  );    
    break;
    }

    }

    } catch (InputMismatchException e) {
    System.out.println("Erro: digite apenas valores numéricos válidos.");
    }

        Entradauser.close();

    }
}