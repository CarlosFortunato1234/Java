package Objetos;
public class Carro { 
    public String cor; 
    public int ano;
    public String marca;
    public String placa; 
    public Boolean estoque; 

    Carro (String cor, int ano, String marca, String placa) {
    this.ano = ano;
    this.cor = cor; 
    this.marca = marca; 
    this.placa = placa; 
    this.estoque = true;
    }

    public void vender () { 
        this.estoque = false; 
    }
}