import java.util.InputMismatchException;
import java.util.Scanner;

public class Questao_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Digite a sua idade: ");
            int idade = sc.nextInt();
           
            if (idade < 18 && idade > 0 ){
                System.out.println("Você é de menor!");
            }
            
           else if (idade >= 18 && idade <60  ){
                System.out.println("Você é de maior!");
            } 

          else  if (idade >=60){
                System.out.println("Você é idoso!");
            }
            
            if (idade < 0) {
                System.out.println("Digite apenas idades maior que 0!");
            }

        } catch (InputMismatchException e) {

            System.out.println("Erro: digite apenas idades completas e sem letras.");

        } finally {

            sc.close();

        }
    }
}