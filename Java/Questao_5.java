package Java;
/*# Questão 5: Menu com switch

Crie um programa de menu que oferece as seguintes opções: (1) Calcular área de um quadrado, 
(2) Calcular área de um círculo,
(3) Calcular perímetro de um retângulo, 
(4) Sair. Utilize switch para controlar o fluxo, Scanner para entrada e try/catch para tratamento de erros. */

import java.util.InputMismatchException;
import java.util.Scanner;
public class Questao_5 {
    public static void main(String[] args) {

        Scanner Entradauser = new Scanner(System.in);

        try {
            System.out.println("Bem vindo ao calculador geometrico!");    
            System.out.println("Verifique áreas de quadrados, circulos e perímetros de retângulos. Caso queira sair, basta digitar a opção 4.");   
            System.out.println("");   
            System.out.println("========MENU==========="); 
            System.out.println("Opção 1: Área do quadrado");   
            System.out.println("Opção 2: Área do círculo");   
            System.out.println("Opção 3: Perímetro do retângulo");
            System.out.println("Opção 4: Sair!");
      
            System.out.println("\n\n");

            System.out.println("Escolha uma opção: ");
            int opcao = Entradauser.nextInt();
           
            	switch(opcao) {
		case 1: {
            System.out.println("Digite o lado do quadrado em metros: ");    
            double lado = Entradauser.nextDouble();

            double areaQuadrado;
            areaQuadrado = lado * lado; 
             System.out.println("A área do quadrado é:" + areaQuadrado + " m²"  );    
            


            break; 
        }

        case 2: { 
            System.out.println("Digite o raio deste círculo em metros");
             double raioCirculo = Entradauser.nextDouble();
            System.out.println("Digite qual é o valor de Pi usado para este cálculo, usando vírgula: (Sugestão 3,14)");
             double pi = Entradauser.nextDouble();


             double areaCirculo; 
             
            areaCirculo = pi * (raioCirculo * raioCirculo );

             System.out.println("A área do círculo é:" + areaCirculo + " m²"  ); 
            break; 
        }

        case 3: {
              System.out.println("Digite a base desse retângulo em metros: ");
              double baseRetangulo = Entradauser.nextDouble();
              System.out.println("Digite a altura desse retângulo em metros: ");
              double alturaRetangulo = Entradauser.nextDouble();
              
              double perimetroRetangulo;
//
              perimetroRetangulo = 2 * (baseRetangulo + alturaRetangulo);
                      
              System.out.println("O perímetro do retângulo é: " + perimetroRetangulo + " m"  ); 
            
              break;
        }
            
        case 4: {
              System.out.println("Encerrando o programa...");
              return;
        }
        default: {
    System.out.println("Opção inválida!");
               break;
        }


                } // fecha chaves do switch
            } //fecha o try
       catch (InputMismatchException e) {
               System.out.println("Erro: digite apenas valores numéricos válidos.");
      }
         Entradauser.close();

    }
}

