/* # Questão1 Cadastro e análise de notas com array desenvolva um programa que solicite ao usuário a quantidade
de alunos de uma turma e armazene as notas deles em um array de double. O programa deve calcular 
e exibir a média da turma, a maior nota, a menor nota,
 e a quantidade de alunos aprovados, considerando a média mínima = 6,0. */
import java.util.InputMismatchException;
import java.util.Scanner;


public class Questao1_vetor {
    public static void main(String[] args) {

        Scanner Entradauser = new Scanner(System.in);

     try {
    System.out.println("Bem vindo ao gerenciamento de classe!");    
    System.out.println("Insira a quantidade de alunos:");   
    int numeroAlunos = Entradauser.nextInt();
    double [] notas = new double [numeroAlunos];
    int aprovado = 0;
    int reprovado = 0;
    double soma = 0;
    double media = 0;
    double maiorNota = 0; 
    double menorNota = 0; 
    for (int i = 0; i < numeroAlunos; i++) {
        System.out.println("Digite a nota do " + ( i + 1 ) + " aluno:" );      
        notas[i] = Entradauser.nextDouble();
       


    if (notas [i] >= 6.0 && notas [i] < 11) {
        aprovado++;
    
        soma += notas [i];
        }
        else if (notas [i] <= 5.9 && notas [i] >= 0) {
         reprovado++;
         soma += notas [i];
        }
        else { 
        System.out.println("Digite uma nota válida!");   
          i--;
            }

        if (i == 0) {
          maiorNota = notas[i];
          menorNota = notas[i];
        }
        
        else {
        if (notas[i] > maiorNota) {
            maiorNota = notas[i];
    }

        if (notas[i] < menorNota) {
        menorNota = notas[i];
    }
}
          
    } 

        media = (soma / numeroAlunos); 
        if (aprovado > 1) {
         System.out.println("A quantidade de alunos aprovados é de: " +  aprovado + " alunos." );      
        }
        else if (aprovado <= 0) {
            System.out.println("Não houve alunos aprovados." ); 
        } else {
            System.out.println("A quantidade de alunos aprovados é de: " +  aprovado + " aluno." );    
        }

        if (reprovado > 1) {
            System.out.println("A quantidade de alunos reprovados é de: " + reprovado + " alunos." );      
        }
        else if (reprovado <= 0) {
              System.out.println("Não houve alunos reprovados." ); 
         }
        else { 
            System.out.println("A quantidade de alunos reprovados é de: " + reprovado + " aluno." ); 
        }
   
        System.out.println("A média de notas da sala é: " + media + "." );   
        System.out.println("A menor nota é: " +  menorNota);     
        System.out.println("A maior nota é: " +  maiorNota);  
        
    

        }
   catch (InputMismatchException e) {
    
             System.out.println("Digite apenas numeros inteiros!");
        }
     Entradauser.close();
        }
    }