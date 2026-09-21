import java.util.Scanner;

public class Revenda {

    public static void main(String[] args) {
        System.out.println("Revenda");
        Scanner s = new Scnner (System.in);
        System.out.println("Digite a cor do carro: ");
        String cor = s.next();
        System.out.println("Digite o ano do carro"); 
        int ano = s.nextInt();
        System.out.println("Digite a marca do carro: ");
        String marca = s.next();
        System.out.println("Digite a placa do carro: ");
        String placa = s.next(); 

        Carro carro = new Carro(
        cor,
        ano,
        marca,
        placa
        );

        System.out.println(carro.cor);
        System.out.println(carro.placa);
        System.out.println(carro.ano);
        System.out.println(carro.marca);
    }
}