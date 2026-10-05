package Exercicio_avalitivo;

public class Robo {
    public int codigo; 
    public String nome;
    public int ataque;
    public int defesa; 
    public int energia; 
    public int vitorias;
    public int derrotas; 
    public int pontos;
    public int combates;  

    Robo (int codigo, String nome, int ataque, int defesa, int energia, int vitorias, int derrotas, int pontos, int combates) {
    this.codigo = codigo; 
    this.nome = nome; 
    this.ataque = ataque; 
    this.defesa = defesa; 
    this.energia = energia;
    this.vitorias = vitorias;
    this.derrotas = derrotas;
    this.pontos = pontos;
    this.combates = combates; 
    }
    

    // MEUS MÉTODOS: 


    // MÉTODO DE COMBATE, PARA DEPOIS CHAMAR NA MAIN: 
 //receber dano

 public void receberDano (int dano) {
    this.energia = this.energia - dano; 

    if (this.energia < 0) {
        this.energia = 0; // aqui estou parametrizando para que a energia do meu adversário nunca fique negativa!  
    }
 }
 // registrar vitórias;

 public void vencer() {
  vitorias = vitorias + 1; //vitorias

  pontos = pontos + 3; //pontos
  combates = combates + 1;  //gravar a estatística de combates
 }

 //registrar derrotas ;

 public void perder() {
    derrotas = derrotas + 1;
    combates = combates + 1; 

 }

 // registrar empates: 

 public void empatar () { 
   pontos = pontos + 1; 
   combates = combates + 1; 
 }
  public void verificarEnergia() {

   if (this.energia >= 30) {
      System.out.println("Robo Disponível!");
   }
      else {
         System.out.println("Em recuperação!");
      }
      
   }


   // Metódo para recuperar energia

   public void recuperarEnergia (int quantidade) {
      if (quantidade <= 0) { 
         System.out.println("A quantidade deve ser positiva! ");

      }
      else if (quantidade % 10 != 0) {
         System.out.println("A quantidade deve ser múltipla de 10!");
      }
      else if (energia + quantidade > 100) {
         System.out.println( "A energia não pode ultrapassar 100!");
      }
      else if (pontos < quantidade / 10) {
         System.out.println( "Pontos insuficientes!");
      }
      else {
         energia = energia + quantidade; 
         pontos = pontos - (quantidade / 10); // essa lógica eu faço para definir aquela regra de  cada bloco de energia custar 1 ponto e 
         // ele divide a quantidade por 10 para descobrir quantos blocos são e subtrai a variável pontos por esse resultado do bloco de energia. 

         System.out.println("Energia recuperada com sucesso! ");
      }
   }

   //classe de ataque 

   public int atacar (Robo adversario, int rodada) {  
       int dano = this.ataque - adversario.defesa; 

       if (dano < 5) { 
         dano = 5;                  // isso é para definir que o dano mínimo é 5. 
           }
      
      if (rodada  % 2 == 0) {
         dano = dano + 5;             //bônus das rodadas pares
      }

      adversario.receberDano (dano);
         return dano; 
      }
     
  }

    
