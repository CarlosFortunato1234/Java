package Objetos;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

 
public class Exercicio_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();
        int opt = -1;
        do {
            System.out.println("=========== SISTEMA DE GERENCIAMENTO DE CLASSE  =======");
            System.out.println("0. Sair");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Exibir dados dos alunos");
            System.out.println("3. Mostrar quantos alunos foram aprovados");
            System.out.println("4. Mostrar a mior média da turma");
            System.out.println("Digite a operação: ");
            opt = buscarOperacao(s);
            switch (opt) { 
                case 0:
                    System.out.println("Tchau!");
                    break;
                case 1:
                    System.out.println("Digite o nome do aluno: ");
                    s.nextLine();  // limpar o enter
                    String nome = s.nextLine();
                    System.out.println("Digite a idade do aluno");
                    int idade  = s.nextInt();
                    System.out.println("Digite a primeira nota do aluno (a): ");
                    double nota1 = s.nextDouble();
                    System.out.println("Digite a segunda nota do aluno (a): ");
                    double nota2 = s.nextDouble();

                    Aluno aluno = new Aluno (
                      nome,
                      idade,
                      nota1,
                      nota2
                    );
                    alunos.add(aluno);
                    break;
                case 2:
                 for (Aluno a : alunos) {
                          a.estaAprovado();
                         a.exibirSituacao();
                     }
                    break;

                 case 3:
                    int aprovados = 0;

                    for (Aluno a : alunos) {
                        a.estaAprovado();
                    
                        if (a.aprovado) {
                        aprovados++;
                    }
                    }
  
                    System.out.println("Quantidade de alunos aprovados: " + aprovados);

                    break;


                case 4:
                    double maiorMedia = 0;

                    for (Aluno a : alunos ) { 
                         double media = a.calcularMedia();

                         if (media > maiorMedia) {
                            maiorMedia = media;
                    } 
                }

                System.out.println("A maior média da turma é: " + maiorMedia);

                break;


            }
        } while (opt != 0);
        s.close();
    }
 
    public static int buscarOperacao(Scanner s) {
        int opt = -1;
        do {
            try {
                opt = s.nextInt();
            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Operação inválida");
                System.out.println("Digite novamente a informação!");
                opt = -1;
            }
        } while (opt < 0);
 
        return opt;
    }
}
 