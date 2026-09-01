package Java;
/*# Questão 9: Validação de Entrada com Múltiplos try/catch

Implemente um programa que leia três números decimais do usuário e calcule a média aritmética. Utilize múltiplos blocos try/catch para tratar diferentes tipos de exceção 
(NumberFormatException, InputMismatchException). Valide se os números são positivos com if/else. */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Questao_9{

    public static void main(String[] args) {

        Scanner Entradauser = new Scanner(System.in);
//
        try {
    System.out.println("Bem vindo ao calculador de média aritimética");    
    System.out.println("Digite 3 números, que lhe trarei a média.");   

    System.out.println("Digite o primeiro numero: ");      
    double numero1 = Entradauser.nextDouble();
    System.out.println("Digite o segundo numero: ");      
    double numero2 = Entradauser.nextDouble();
    System.out.println("Digite o terceiro numero: ");      
    double numero3 = Entradauser.nextDouble();
    

    double media = (numero1 + numero2 + numero3) / 3;
    System.out.println("A média aritmética é: " + media);
        }
    catch (InputMismatchException e) {
    System.out.println("Erro: digite apenas valores numéricos válidos.");
    }
    catch (NumberFormatException e) {
        System.out.println("Erro ao converter o valor para número");
    }
     Entradauser.close();
}
}

//não terminei, falta os if e else