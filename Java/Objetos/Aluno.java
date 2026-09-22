package Objetos;

public class Aluno {
    public String nome; 
    public int idade;
    public double nota1;
    public double nota2; 
    public boolean aprovado; 

    Aluno (String nome, int idade, double nota1, double nota2) {
    this.nome = nome;
    this.idade = idade; 
    this.nota1 = nota1; 
    this.nota2 = nota2; 
    }

    public double calcularMedia () { 
        return (this.nota1 + this.nota2) / 2;
    }
    
    public void estaAprovado () {
        double media = calcularMedia(); 

        if (media >= 7) {
            this.aprovado = true;
        }
        else { 
             
            this.aprovado = false; 

        }
    }

    public void exibirSituacao () {
        System.out.println("Aluno: " + this.nome);
        System.out.println("idade: " + this.idade);
        System.out.println("Primeira nota: " + this.nota1);
        System.out.println("Segunda nota: " + this.nota2);
        System.out.println("Média: " + calcularMedia());
        if (aprovado) {
            System.out.println("Aluno (a) Aprovado!"); 
        }
        else {
            System.out.println("Aluno (a) reprovado! ");
        }
    }
}
