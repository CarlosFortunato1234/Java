import java.util.InputMismatchException;
import java.util.Scanner;

public class Questao_1 {

    public static void main(String[] args) {

        Scanner Entradauser = new Scanner(System.in);

        System.out.println("=== CADASTRO E ANÁLISE DE NOTAS ===");
        System.out.println();

        try {

            System.out.println("Digite a quantidade de alunos da turma:");
            int quantidadeAlunos = Entradauser.nextInt();

            if (quantidadeAlunos <= 0) {
                System.out.println("A quantidade de alunos deve ser maior que zero.");
                Entradauser.close();
                return;
            }

            double[] notas = new double[quantidadeAlunos];

            double soma = 0;
            double maiorNota = 0;
            double menorNota = 10;
            int aprovados = 0;

            for (int i = 0; i < notas.length; i++) {

                System.out.println("Digite a nota do aluno " + (i + 1) + ":");
                notas[i] = Entradauser.nextDouble();

                soma = soma + notas[i];

                if (notas[i] > maiorNota) {
                    maiorNota = notas[i];
                }

                if (notas[i] < menorNota) {
                    menorNota = notas[i];
                }

                if (notas[i] >= 6.0) {
                    System.out.println("Aluno aprovado!");
                    aprovados++;
                } else {
                    System.out.println("Aluno reprovado!");
                }

                System.out.println();
            }

            double media = soma / quantidadeAlunos;

            System.out.println("=== RESULTADO DA TURMA ===");
            System.out.println("Média da turma: " + media);
            System.out.println("Maior nota: " + maiorNota);
            System.out.println("Menor nota: " + menorNota);
            System.out.println("Quantidade de alunos aprovados: " + aprovados);

        } catch (InputMismatchException e) {

            System.out.println("Erro: digite apenas valores numéricos válidos.");

        }

        Entradauser.close();
    }
}