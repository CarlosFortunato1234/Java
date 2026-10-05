package Exercicio_avalitivo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Robo> robos = new ArrayList<>(); //arraylist dos meus robos no programa
        int opt = -1;
        // Esse aqui é o meu MENU com as interações principais do usuário
        do {
            System.out.println("=========== CAMPEONATO DE ROBOS  ===========");
            System.out.println("BEEEM VINDO AO CAMPEONATO DE ROBOS MAIS BRUTAL DA HISTÓRIA!");
            System.out.println("DIGITE UMA OPÇÃO: ");
            System.out.println("0. Sair ");
            System.out.println("1. Cadastrar ou Consultar Robos: ");
            System.out.println("2. Realizar um combate: ");
            System.out.println("3. Recuperar energia: ");
            System.out.println("4. Executar uma rodada geral: ");
            System.out.println("5. Exibir classificação: ");
            System.out.println("6. Emitir estatísticas: ");
            System.out.println("7. Excluir participante: ");
            System.out.println("Digite a operação: ");
            opt = leitorMenu(s); //buscar operação é um método que fiz lá no final da main
            switch (opt) {
                case 0:
                    System.out.println("Tchau!");
                    break;
                case 1:
                    // INICIO DO CASE 1

                    System.out.println("== GERENCIAMENTO DE ROBOS: ");
                    System.out.println("1- Cadastrar Robo: ");
                    System.out.println("2- Consultar Robo: ");
                    System.out.println("3- Listar todos os robos: ");
                    System.out.println("Digite uma opção: ");
                    int opcaoRobo = leitorGeral(s);

                    //esse é o if caso o usuário escolha cadastrar o robo: 
                    if (opcaoRobo == 1) {

                        System.out.println("Digite o código do robo: ");
                        int codigo = leitorGeral(s);

                        // VALIDAÇÕES
                        while (codigo <= 0) {
                            System.out.println("Código inválido! Digite um código positivo:");
                            codigo = leitorGeral(s);
                        }
                        boolean codigoExiste = false; //aqui já deixo pré definido que código não existe

                        for (Robo r : robos) {  // depois lanço esse for percorrendo os robos, tentando achar um código do robo = o código que o cara escreveu
                            if (r.codigo == codigo) {
                                codigoExiste = true;
                                break;
                            }
                        }

                        while (codigoExiste == true) { //se cair nessse while, de código existe = true, ele vai ficar tentando encontrar se o novo código que o usuário digitou já não existe.
                            System.out.println("Código já cadastrado! Digite outro: ");
                            ;
                            codigo = leitorGeral(s);

                            codigoExiste = false;

                            for (Robo r : robos) {
                                if (r.codigo == codigo) {
                                    codigoExiste = true;
                                    break;
                                }
                            }
                        }

                        // FIM DAS VALIDAÇÕES

                        System.out.println("Digite o nome do robo: ");
                        s.nextLine(); // limpa o enter de novo

                        String nome = s.nextLine();
                        System.out.println("Digite o ataque do robo entre 10 e 30:  ");
                        int ataque = leitorGeral(s); //criei esse leitorGeral baseado no scanner, pois assim ele já realiza as validações que o exercício pede acerca de entradas dos usuários

                        while (ataque < 10 || ataque > 30) {
                            System.out.println("Ataque inválido! Digite um ataque entre 10 e 30! ");
                            ataque = leitorGeral(s);
                        }
                        System.out.println("Digite a defesa do robo entre 0 e 20: ");
                        int defesa = leitorGeral(s);

                        while (defesa < 0 || defesa > 20) {
                            System.out.println("Defesa Inválida! Digite uma defesa entre 0 e 20: ");
                            defesa = leitorGeral(s);
                        }

                        Robo robo = new Robo(
                                codigo,
                                nome,
                                ataque,
                                defesa,
                                100,
                                0,
                                0,
                                0,
                                0);
                        robos.add(robo); //aqui eu estou guardando o robo recém criado na lista dos robos existentes.

                        System.out.println("Robô cadastrado com sucesso!");

                    } else if (opcaoRobo == 2) {
                        System.out.println("Digite o código do robo que deseja consultar: ");
                        int codigoBusca = leitorGeral(s);

                        boolean encontrado = false;

                        for (Robo r : robos) {

                            if (r.codigo == codigoBusca) {
                                System.out.println("====== ROBÔ ENCONTRADO ======");
                                System.out.println("Código:  " + r.codigo);
                                System.out.println("Nome: " + r.nome);
                                System.out.println("Ataque: " + r.ataque);
                                System.out.println("Defesa: " + r.defesa);
                                System.out.println("Energia: " + r.energia);
                                System.out.println("Vitórias: " + r.vitorias);
                                System.out.println("Derrotas: " + r.derrotas);
                                System.out.println("Pontos: " + r.pontos);
                                System.out.println("Combates: " + r.combates);

                                r.verificarEnergia();
                                encontrado = true;
                                break;

                            }

                        }
                        if (encontrado == false) {
                            System.out.println("Robô não encontrado!");
                        }

                    }
                      else if (opcaoRobo == 3) {
                        // listar todos: primeiro vejo se a lista está vazia
                        if (robos.isEmpty()) {
                            System.out.println("Nenhum robô cadastrado!");
                        } else {
                            System.out.println("====== LISTA DE ROBÔS ======");
                            for (Robo r : robos) {
                                System.out.println("Código: " + r.codigo + " || Nome: " + r.nome);
                                System.out.println("Ataque: " + r.ataque + " || Defesa: " + r.defesa + " ||Energia: " + r.energia);
                                System.out.println("Vitórias: " + r.vitorias + " || Derrotas: " + r.derrotas
                                        + " || Pontos: " + r.pontos + " || Combates: " + r.combates);
                                r.verificarEnergia(); // mostra Disponível (energia >= 30) ou Em recuperação (energia < 30)
                                System.out.println("----------------------------");
                            }
                        }

                    } else {
                        System.out.println("Opção inválida!");
                    }

                    break;
                // FIM DO CASE 1
                         case 2:
                    // INCIO DO CASE 2
                    System.out.println("Digite o código do primeiro robo: ");
                    int codigo1 = leitorGeral(s);

                    System.out.println("Digite o código do segundo robo: ");
                    int codigo2 = leitorGeral(s);

                    // abaixo eu busco os dois robos na lista
                    // começo com robo1 e robo2 = null, e caso ele encontre o código na lista
                    // guardo o robô ali, se continuar null é pq ele nao existe
                    Robo robo1 = null;
                    Robo robo2 = null;

                    for (Robo r : robos) {
                        if (r.codigo == codigo1) {
                            robo1 = r;
                        }
                        if (r.codigo == codigo2) {
                            robo2 = r;
                        }
                    }

                    // INICIO DAS VALIDAÇÕES
                    // se cair em qualquer um desses ifs o combate não acontece e ninguém é alterado
                    if (codigo1 == codigo2) {
                        System.out.println("Os robôs devem ser diferentes! ");

                    } else if (robo1 == null || robo2 == null) {
                        System.out.println("Um ou mais robôs não existem! ");

                    } else if (robo1.energia < 30) {
                        System.out.println("O primeiro robô está em recuperação! ");

                    } else if (robo2.energia < 30) {
                        System.out.println("O segundo robô está em recuperação! ");

                    }
                    // FIM DAS VALIDAÇÕES
                    else {
                        // se chegou aqui o combate está autorizado
                        System.out.println("COMBATE AUTORIZADO! ");

                        // aqui eu defino quem ataca primeiro ANTES de começar a luta
                        // o exercício diz que ataca primeiro quem tem MENOS pontos
                        // e se der empate de pontos ataca o de menor código
                        // guardo em "primeiro" e "segundo" e essa ordem vale pro combate inteiro
                        Robo primeiro;
                        Robo segundo;

                        if (robo1.pontos < robo2.pontos) {
                            primeiro = robo1;
                            segundo = robo2;
                        } else if (robo2.pontos < robo1.pontos) {
                            primeiro = robo2;
                            segundo = robo1;
                        } else if (robo1.codigo < robo2.codigo) {
                            primeiro = robo1;
                            segundo = robo2;
                        } else {
                            primeiro = robo2;
                            segundo = robo1;
                        }

                        System.out.println(primeiro.nome + " ataca primeiro em todas as rodadas! ");
                        System.out.println("Energia inicial: " + primeiro.nome + " = " + primeiro.energia
                                + " | " + segundo.nome + " = " + segundo.energia);

                        int rodada = 1;

                        // o combate tem até 5 rodadas, mas para antes se algum robô zerar a energia
                        // por isso a condição tem as 3 coisas juntas
                        while (rodada <= 5 && primeiro.energia > 0 && segundo.energia > 0) {
                            System.out.println("===== RODADA " + rodada + " =====");

                            // ataque do primeiro robô
                            int dano = primeiro.atacar(segundo, rodada);
                            System.out.println(primeiro.nome + " atacou " + segundo.nome + " e causou " + dano + " de dano.");
                            System.out.println("Energia restante de " + segundo.nome + ": " + segundo.energia);

                            // o contra-ataque só acontece se o segundo ainda estiver vivo
                            // se ele zerou o combate acaba na hora, sem direito a contra-ataque
                            if (segundo.energia > 0) {
                                dano = segundo.atacar(primeiro, rodada);
                                System.out.println(segundo.nome + " atacou " + primeiro.nome + " e causou " + dano + " de dano.");
                                System.out.println("Energia restante de " + primeiro.nome + ": " + primeiro.energia);

                                if (primeiro.energia == 0) {
                                    System.out.println(primeiro.nome + " ficou sem energia! Combate encerrado.");
                                }
                            } else {
                                System.out.println(segundo.nome + " ficou sem energia! Combate encerrado, sem contra-ataque.");
                            }

                            rodada = rodada + 1;
                        }

                        // RESULTADO FINAL
                        System.out.println("===== RESULTADO FINAL =====");
                        System.out.println("Energia final: " + primeiro.nome + " = " + primeiro.energia
                                + " | " + segundo.nome + " = " + segundo.energia);

                        // primeiro vejo se alguém zerou, quem zerou perdeu
                        // se ninguém zerou, vence quem tem mais energia restante
                        // se a energia for igual é empate
                        // vencer() dá 3 pontos e 1 vitória, perder() dá 1 derrota
                        // empatar() dá 1 ponto pra cada, sem mexer em vitórias e derrotas
                        if (primeiro.energia == 0) {
                            System.out.println(segundo.nome + " VENCEU!");
                            segundo.vencer();
                            primeiro.perder();

                        } else if (segundo.energia == 0) {
                            System.out.println(primeiro.nome + " VENCEU!");
                            primeiro.vencer();
                            segundo.perder();

                        } else if (primeiro.energia > segundo.energia) {
                            System.out.println(primeiro.nome + " VENCEU!");
                            primeiro.vencer();
                            segundo.perder();

                        } else if (segundo.energia > primeiro.energia) {
                            System.out.println(segundo.nome + " VENCEU!");
                            segundo.vencer();
                            primeiro.perder();

                        } else {
                            System.out.println("EMPATE!");
                            primeiro.empatar();
                            segundo.empatar();
                        }
                    }

                    break;

                case 3:
                    // INICIO DO CASE 3

                    int codigoRobo = 0;
                      int qtdeEnergia = 0;

                     System.out.println("====== RECUPERAÇÃO DE ENERGIA ====== ");
                     System.out.println("ATENÇÃO! O número deverá ser positivo e múltiplo de 10! ");
                     System.out.println("Cada bloco de 10 de energia custará um ponto no campeonato.");
                     System.out.println("============================================================ ");
                     System.out.println("Digite o código do robo:");
                     codigoRobo = leitorGeral(s);

                     //validações se o código do robo é valido: 

                     Robo roboRecuperar = null;
                     //guardo o robô, se continuar null é pq ele nao existe

                     for (Robo r : robos) {
                        if (r.codigo == codigoRobo) {
                            roboRecuperar = r;
                        }
                     }

                     if (roboRecuperar == null) {
                       System.out.println("Robô não encontrado!");
                     } else {
                        System.out.println("Digite a quantidade de energia: ");
                        qtdeEnergia = leitorGeral(s);

                        // validação se a quantidade de energia é valida (positiva, múltipla de 10 e que não passe de 100)
                        // e se o robo tem pontos suficientes: quem faz essas validações é o método
                        // recuperarEnergia da classe Robo, pq são regras que protegem a energia e os pontos do robô
                        // se alguma condição falhar ele recusa a operação inteira e não altera nada
                        roboRecuperar.recuperarEnergia(qtdeEnergia);

                        System.out.println("Situação atual de " + roboRecuperar.nome + ": energia = " + roboRecuperar.energia + " | pontos = " + roboRecuperar.pontos);
                    }



                    
                    break;
                // FIM DO CASE 3
                case 4:
                    // INICIO DO CASE 4

                    // 1) pego a classificação atual (lista auxiliar, a lista principal não muda)
                    ArrayList<Robo> classificacaoRodada = montarClassificacao(robos);
                    ArrayList<Robo> disponiveisRodada = new ArrayList<>();

                    // só participa quem está DISPONÍVEL (energia >= 30) no início da operação
                    // como a lista já está em ordem de classificação, os disponíveis ficam na mesma ordem
                    for (Robo r : classificacaoRodada) {
                        if (r.energia >= 30) {
                            disponiveisRodada.add(r);
                        }
                    }

                    // menos de 2 disponíveis: recusa a operação e NÃO dá ponto de folga
                    if (disponiveisRodada.size() < 2) {
                        System.out.println("Rodada geral recusada! É preciso ter pelo menos 2 robôs disponíveis.");
                    } else {

                        // 2) defino TODOS os confrontos ANTES de lutar
                        // duas listas paralelas: o confronto k é confrontoA[k] contra confrontoB[k]
                        // 1º x 2º, 3º x 4º e assim por diante
                        ArrayList<Robo> confrontoA = new ArrayList<>();
                        ArrayList<Robo> confrontoB = new ArrayList<>();
                        Robo roboFolga = null;

                        int i = 0;
                        while (i + 1 < disponiveisRodada.size()) {
                            confrontoA.add(disponiveisRodada.get(i));
                            confrontoB.add(disponiveisRodada.get(i + 1));
                            i = i + 2;
                        }

                        // se sobrou 1 (quantidade ímpar), o último fica sem adversário e ganha a folga
                        if (i < disponiveisRodada.size()) {
                            roboFolga = disponiveisRodada.get(i);
                        }

                        // mostro os confrontos que foram definidos
                        System.out.println("====== CONFRONTOS DA RODADA GERAL ======");
                        for (int k = 0; k < confrontoA.size(); k++) {
                            System.out.println((k + 1) + ") " + confrontoA.get(k).nome + " x " + confrontoB.get(k).nome);
                        }
                        if (roboFolga != null) {
                            System.out.println("Folga: " + roboFolga.nome);
                        }

                        // 3) executo os combates na ordem; os resultados não mudam os confrontos já definidos
                        for (int k = 0; k < confrontoA.size(); k++) {
                            System.out.println("========== CONFRONTO " + (k + 1) + " ==========");
                            executarCombate(confrontoA.get(k), confrontoB.get(k));
                        }

                        // 4) folga: 1 ponto, sem contar como combate
                        if (roboFolga != null) {
                            roboFolga.receberFolga();
                            System.out.println(roboFolga.nome + " ficou sem adversário e recebeu 1 ponto de folga.");
                        }
                    }

                    break;
                // FIM DO CASE 4

                case 5:
                    // INICIO DO CASE 5

                    if (robos.isEmpty()) {
                        System.out.println("Nenhum robô cadastrado!");
                    } else {
                        // a ordenação é feita numa lista auxiliar, a ordem de cadastro da lista "robos" não muda
                        ArrayList<Robo> classificacao = montarClassificacao(robos);

                        System.out.println("====== CLASSIFICAÇÃO ======");
                        for (int i = 0; i < classificacao.size(); i++) {
                            Robo r = classificacao.get(i);
                            System.out.println((i + 1) + "º | Código: " + r.codigo + " | Nome: " + r.nome
                                    + " | Pontos: " + r.pontos + " | Vitórias: " + r.vitorias
                                    + " | Energia: " + r.energia);
                        }
                    }

                    break;
                // FIM DO CASE 5

                case 6:
                    // INICIO DO CASE 6

                    if (robos.isEmpty()) {
                        System.out.println("Nenhum robô cadastrado!");
                    } else {
                        System.out.println("====== ESTATÍSTICAS ======");

                        // quantidade de robôs cadastrados
                        System.out.println("Robôs cadastrados: " + robos.size());

                        // média de energia de TODOS os participantes
                        int somaEnergia = 0;
                        for (Robo r : robos) {
                            somaEnergia = somaEnergia + r.energia;
                        }
                        double mediaEnergia = (double) somaEnergia / robos.size(); // (double) pra não dar divisão de inteiros
                        System.out.printf("Média de energia: %.2f%n", mediaEnergia);

                        // robôs em recuperação (energia menor que 30)
                        boolean temRecuperacao = false;
                        System.out.println("Robôs em recuperação:");
                        for (Robo r : robos) {
                            if (r.energia < 30) {
                                System.out.println("- Código " + r.codigo + " | " + r.nome + " | Energia: " + r.energia);
                                temRecuperacao = true;
                            }
                        }
                        if (temRecuperacao == false) {
                            System.out.println("Nenhum robô em recuperação.");
                        }

                        // maior aproveitamento: ignoro quem nunca lutou (combates == 0)
                        // começo em -1 pra saber se algum robô já lutou
                        double maiorAproveitamento = -1;
                        for (Robo r : robos) {
                            if (r.combates > 0) {
                                if (r.calcularAproveitamento() > maiorAproveitamento) {
                                    maiorAproveitamento = r.calcularAproveitamento();
                                }
                            }
                        }

                        if (maiorAproveitamento < 0) {
                            System.out.println("Nenhum robô lutou ainda, então não há aproveitamento para calcular.");
                        } else {
                            System.out.printf("Maior aproveitamento: %.2f%%%n", maiorAproveitamento);
                            // se houver empate no maior aproveitamento, mostro todos os empatados
                            for (Robo r : robos) {
                                if (r.combates > 0 && r.calcularAproveitamento() == maiorAproveitamento) {
                                    System.out.println("- Código " + r.codigo + " | " + r.nome);
                                }
                            }
                        }
                    }

                    break;
                // FIM DO CASE 6

                case 7:
                    // INICIO DO CASE 7

                    if (robos.isEmpty()) {
                        System.out.println("Nenhum robô cadastrado!");
                    } else {
                        System.out.println("Digite o código do robô que deseja excluir: ");
                        int codigoExcluir = leitorGeral(s);

                        // busco o robô, se continuar null é pq ele não existe
                        Robo roboExcluir = null;
                        for (Robo r : robos) {
                            if (r.codigo == codigoExcluir) {
                                roboExcluir = r;
                            }
                        }

                        if (roboExcluir == null) {
                            System.out.println("Robô não encontrado!");
                        } else if (roboExcluir.combates > 0) {
                            // só pode excluir quem NUNCA fez combate (folga não conta como combate)
                            System.out.println("Exclusão recusada! Esse robô já realizou combates.");
                        } else {
                            robos.remove(roboExcluir);
                            System.out.println("Robô " + roboExcluir.nome + " excluído com sucesso!");
                        }
                    }

                    break;
                // FIM DO CASE 7

            }
        } while (opt != 0);
        s.close();
    }

    //CRIEI o leitor menu especificamente para o menu principal, ele pede especificamente operações de 0 a 7, faz try cath para letras.
    public static int leitorMenu(Scanner s) {
        int opt = -1;
        do {
            try {
                opt = s.nextInt();

                if (opt < 0 || opt > 7) {
                    System.out.println("Operação inválida!");
                    System.out.println("Digite um número entre 0 e 7.");
                    opt = -1;
                }
            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Operação inválida");
                System.out.println("Digite novamente a informação!");
                opt = -1;
            }
        } while (opt < 0);

        return opt;


    }

    // O meu leitor geral está presente no corpo da main inteira, ele valida com try catch, mas ao contrário do leitor menu, ele não tem a restrição do 0 a 7
    public static int leitorGeral(Scanner s) {
    int numero = 0;
    boolean valido = false;

    while (valido == false) {
        try {
            numero = s.nextInt();
            valido = true;
        } catch (InputMismatchException e) {
            s.next();
            System.out.println("Entrada inválida! Digite um número inteiro: ");
        }
    }

    return numero;
}
    


//OPTEI por fazer o executar combate apenas no case 4, pois como o combate geral pode ficar diferente do combate específico, preferi separar os métodos usados no case 2 e 4.
    public static void executarCombate(Robo robo1, Robo robo2) {
        System.out.println("COMBATE AUTORIZADO! ");

        // defino quem ataca primeiro ANTES da luta: menos pontos ataca primeiro, empate = menor código
        Robo primeiro;
        Robo segundo;

        if (robo1.pontos < robo2.pontos) {
            primeiro = robo1;
            segundo = robo2;
        } else if (robo2.pontos < robo1.pontos) {
            primeiro = robo2;
            segundo = robo1;
        } else if (robo1.codigo < robo2.codigo) {
            primeiro = robo1;
            segundo = robo2;
        } else {
            primeiro = robo2;
            segundo = robo1;
        }

        System.out.println(primeiro.nome + " ataca primeiro em todas as rodadas! ");
        System.out.println("Energia inicial: " + primeiro.nome + " = " + primeiro.energia
                + " | " + segundo.nome + " = " + segundo.energia);

        int rodada = 1;

        // até 5 rodadas, mas para antes se alguém zerar a energia
        while (rodada <= 5 && primeiro.energia > 0 && segundo.energia > 0) {
            System.out.println("===== RODADA " + rodada + " =====");

            int dano = primeiro.atacar(segundo, rodada);
            System.out.println(primeiro.nome + " atacou " + segundo.nome + " e causou " + dano + " de dano.");
            System.out.println("Energia restante de " + segundo.nome + ": " + segundo.energia);

            // contra-ataque só se o segundo ainda estiver vivo
            if (segundo.energia > 0) {
                dano = segundo.atacar(primeiro, rodada);
                System.out.println(segundo.nome + " atacou " + primeiro.nome + " e causou " + dano + " de dano.");
                System.out.println("Energia restante de " + primeiro.nome + ": " + primeiro.energia);

                if (primeiro.energia == 0) {
                    System.out.println(primeiro.nome + " ficou sem energia! Combate encerrado.");
                }
            } else {
                System.out.println(segundo.nome + " ficou sem energia! Combate encerrado, sem contra-ataque.");
            }

            rodada = rodada + 1;
        }

        System.out.println("===== RESULTADO FINAL =====");
        System.out.println("Energia final: " + primeiro.nome + " = " + primeiro.energia
                + " | " + segundo.nome + " = " + segundo.energia);

        // quem zerou perdeu; se ninguém zerou vence quem tem mais energia; energia igual = empate
        if (primeiro.energia == 0) {
            System.out.println(segundo.nome + " VENCEU!");
            segundo.vencer();
            primeiro.perder();

        } else if (segundo.energia == 0) {
            System.out.println(primeiro.nome + " VENCEU!");
            primeiro.vencer();
            segundo.perder();

        } else if (primeiro.energia > segundo.energia) {
            System.out.println(primeiro.nome + " VENCEU!");
            primeiro.vencer();
            segundo.perder();

        } else if (segundo.energia > primeiro.energia) {
            System.out.println(segundo.nome + " VENCEU!");
            segundo.vencer();
            primeiro.perder();

        } else {
            System.out.println("EMPATE!");
            primeiro.empatar();
            segundo.empatar();
        }
    }

    // compara dois robôs pela regra da classificação, devolve true se o "a" fica NA FRENTE do "b"
    // ordem dos critérios: mais pontos, mais vitórias, mais energia e por último menor código


    //O veio antes recebe dois robos (robo a e robo b) e responde true se o a deve ficar na frente do b na classificação, ou false se não, para isso uso boolean tambem.
    public static boolean veioAntes(Robo a, Robo b) {
      // os meus ifs seguem a ordem do enunciado sendo =! diferente de.

      //ele funciona como um boolean, por exemplo
      //se a.pontos = 6 
      //e b.pontos = 7

      //os pontos são diferentes, mas 6 > 7? FALSE, logo, o return será false, assim b será maior que a. 
        if (a.pontos != b.pontos) {
            return a.pontos > b.pontos;
        }
        if (a.vitorias != b.vitorias) {
            return a.vitorias > b.vitorias;
        }
        if (a.energia != b.energia) {
            return a.energia > b.energia;
        }
        return a.codigo < b.codigo;
    }

    // monta a classificação numa lista AUXILIAR, então a lista principal (ordem de cadastro) não é alterada
    // ordenação feita na mão (seleção), sem sort nem Collections.sort
    public static ArrayList<Robo> montarClassificacao(ArrayList<Robo> robos) {
        ArrayList<Robo> classificacao = new ArrayList<>();

        // copio os robôs (são os mesmos objetos, só a lista é nova)
        for (Robo r : robos) {
            classificacao.add(r);
        }

        // pra cada posição i, procuro quem deve ficar nela entre os que sobraram e troco de lugar
        for (int i = 0; i < classificacao.size() - 1; i++) {
            int melhor = i;

            for (int j = i + 1; j < classificacao.size(); j++) {
                if (veioAntes(classificacao.get(j), classificacao.get(melhor))) {
                    melhor = j;
                }
            }

            Robo temp = classificacao.get(i);
            classificacao.set(i, classificacao.get(melhor));
            classificacao.set(melhor, temp);
        }

        return classificacao;
    }
}

