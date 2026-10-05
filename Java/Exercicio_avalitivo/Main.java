package Exercicio_avalitivo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Robo> robos = new ArrayList<>();
        int opt = -1;
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
            opt = buscarOperacao(s);
            switch (opt) {
                case 0:
                    System.out.println("Tchau!");
                    break;
                case 1:
                    // INICIO DO CASE 1

                    System.out.println("== GERENCIAMENTO DE ROBOS: ");
                    System.out.println("1- Cadastrar Robo: ");
                    System.out.println("2- Consultar Robo: ");
                    System.out.println("Digite uma opção: ");
                    int opcaoRobo = s.nextInt();

                    if (opcaoRobo == 1) {

                        System.out.println("Digite o código do robo: ");
                        int codigo = s.nextInt();

                        // VALIDAÇÕES
                        while (codigo <= 0) {
                            System.out.println("Código inválido! Digite um código positivo:");
                            codigo = s.nextInt();
                        }
                        boolean codigoExiste = false;

                        for (Robo r : robos) {
                            if (r.codigo == codigo) {
                                codigoExiste = true;
                                break;
                            }
                        }

                        while (codigoExiste == true) {
                            System.out.println("Código já cadastrado! Digite outro: ");
                            ;
                            codigo = s.nextInt();

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
                        int ataque = s.nextInt();

                        while (ataque < 10 || ataque > 30) {
                            System.out.println("Ataque inválido! Digite um ataque entre 10 e 30! ");
                            ataque = s.nextInt();
                        }
                        System.out.println("Digite a defesa do robo entre 0 e 20: ");
                        int defesa = s.nextInt();

                        while (defesa < 0 || defesa > 20) {
                            System.out.println("Defesa Inválida! Digite uma defesa entre 0 e 20: ");
                            defesa = s.nextInt();
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
                        robos.add(robo);
                    } else if (opcaoRobo == 2) {
                        System.out.println("Digite o código do robo que deseja consultar: ");
                        int codigoBusca = s.nextInt();

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

                    break;
                // FIM DO CASE 1
                         case 2:
                    // INCIO DO CASE 2
                    System.out.println("Digite o código do primeiro robo: ");
                    int codigo1 = lerInteiro(s);

                    System.out.println("Digite o código do segundo robo: ");
                    int codigo2 = lerInteiro(s);

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
                // FIM DO CASE 2
                case 3:
                    // INICIO DO CASE 3
                    break;
                // FIM DO CASE 3
                case 4:
                    // INICIO DO CASE 4
                    break;
                // fim do case 4

                case 5:
                    // inicio do case 5
                    break;
                // fim do case 5

                case 6:
                    // inicio do case 6

                    break;
                // fim do case 6

                case 7:
                    // inicio do case 7

                    break;
                // fim do case 7

            }
        } while (opt != 0);
        s.close();
    }

    public static int buscarOperacao(Scanner s) {
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
    public static int lerInteiro(Scanner s) {
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
}
