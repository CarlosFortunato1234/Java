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
                    int codigo1 = s.nextInt();

                    System.out.println("Digite o código do segundo robo: ");
                    int codigo2 = s.nextInt();

                

                    // abaixo eu faço uma validação para tentar verificar se esses robos existem

                    // defino boolean robo 1 e 2 existe = false e caso ele encontre vai pra true se
                    // continuar false é pq ele nao existe
                    boolean robo1Existe = false;
                    boolean robo2Existe = false;

                    for (Robo r : robos) {
                        if (r.codigo == codigo1) {
                            robo1Existe = true;
                        }
                        if (r.codigo == codigo2) {
                            robo2Existe = true;
                        }

                    }

                    if (robo1Existe == false || robo2Existe == false) {
                        System.out.println("Um ou mais robôs não existem! ");

                    } else if (codigo1 == codigo2) {
                        System.out.println("Os robôs devem ser diferentes! ");

                    } 
                    // INICIO DA VALIDAÇÃO DA ENERGIA: 
                    else {

                        boolean energiaValida = true; 
                        int pontos1 = 0;
                        int pontos2 = 0;
                        for (Robo r: robos) {
                            if (r.codigo == codigo1) {
                                if (r.energia < 30) {
                                    System.out.println("O primeiro robô está em recuperação!");
                                    energiaValida = false;
                                }

                            }
                            if (r.codigo == codigo2) {
                                if (r.energia < 30) {
                                    System.out.println("O segundo robô está em recuperação! ");
                                    energiaValida = false;
                                }
                            }
                            if (r.codigo == codigo1) {
                                pontos1 = r.pontos;
                            }
                            if (r.codigo == codigo2) {
                                pontos2 = r.pontos;
                            }
                        }
                        if (energiaValida == true) {
                            System.out.println("COMBATE AUTORIZADO! ");
                            if (pontos1 > pontos2) {
                                System.out.println("PRIMEIRO ROBO ATACA PRIMEIRO! ");

                            } else if (pontos2 > pontos1) {
                                System.out.println("SEGUNDO ROBO ATACA PRIMEIRO!");

                            }
                              else if (codigo1 < codigo2) {
                                System.out.println("PRIMEIRO ROBO ATACA PRIMEIRO");
                              }
                              else { 
                                System.out.println("Segundo robo ataca primeiro! ");
                              }

                              int rodada = 1; 
                              int ataque1= 0;
                              int defesa1 = 0;
                              int ataque2 = 0;
                              int defesa2 = 0;

                              for (Robo r : robos) {
                                if (r.codigo == codigo1) {
                                    ataque1 = r.ataque;
                                    defesa1 = r.defesa;
                                }
                                if (r.codigo == codigo2) {
                                    ataque2 = r.ataque; 
                                    defesa2 = r.defesa;
                                }
                              }

                              while (rodada <= 5) {
                                System.out.println("===== RODADA" + rodada + " =====");
                                int numeroRodada = rodada;
                                rodada = rodada + 1;

                                int dano = 0;

                               if (pontos1 > pontos2 || (pontos1 == pontos2 && codigo1 < codigo2)) {
    for (Robo r : robos) {
        if (r.codigo == codigo1) {
            dano = ataque1 - defesa2;
        }
    }

} else {
    for (Robo r : robos) {
        if (r.codigo == codigo2) {
             dano = ataque2 - defesa1;

        }
    }
}

 if (dano < 5) {
    dano = 5;
 }
 if (numeroRodada % 2 == 0) {
    dano = dano + 5;
}
 if (pontos1 > pontos2 || (pontos1 == pontos2 && codigo1 < codigo2)) {

    for (Robo r : robos) {
        if (r.codigo == codigo2) {
            r.receberDano(dano);
            System.out.println("Energia do segundo robo: " + r.energia);
        }
    }

} else {

    for (Robo r : robos) {
        if (r.codigo == codigo1) {
            r.receberDano(dano);
            System.out.println("Energia do primeiro robo: " + r.energia);
        }
    }
}
 System.out.println("Dano casusado: " + dano);
 if (pontos1 > pontos2 || (pontos1 == pontos2 && codigo1 < codigo2)) {
    for (Robo r : robos) {
        if (r.codigo == codigo2 && r.energia == 0) {
            System.out.println("SEGUNDO ROBO FOI DERROTADO!");
            rodada = 6;
        }
    }
} else {
    for (Robo r : robos) {
        if (r.codigo == codigo1 && r.energia == 0) {
            System.out.println("PRIMEIRO ROBO FOI DERROTADO!");
            rodada = 6;
        }
    }
}
 if (pontos1 > pontos2 || (pontos1 == pontos2 && codigo1 < codigo2)) {

    for (Robo r : robos) {
        if (r.codigo == codigo2 && r.energia > 0) {

            int contraAtaque = ataque2 - defesa1;

            if (contraAtaque < 5) {
                contraAtaque = 5;
            }

            for (Robo r2 : robos) {
                if (r2.codigo == codigo1) {
                    r2.receberDano(contraAtaque);
                    System.out.println("Contra-ataque! Dano: " + contraAtaque);
                    System.out.println("Energia do primeiro robo: " + r2.energia);
                   if (r2.energia == 0) {
                rodada = 6;
                    }
                }
            }
        }
    }

} else {

    for (Robo r : robos) {
        if (r.codigo == codigo1 && r.energia > 0) {

            int contraAtaque = ataque1 - defesa2;

            if (contraAtaque < 5) {
                contraAtaque = 5;
            }

            for (Robo r2 : robos) {
                if (r2.codigo == codigo2) {
                    r2.receberDano(contraAtaque);
                    System.out.println("Contra-ataque! Dano: " + contraAtaque);
                    System.out.println("Energia do segundo robo: " + r2.energia);
                    if (r2.energia == 0) {
    rodada = 6;
}
                }
            }
        }
    }
}
 

                    }
                    
                } 
                int energia1 = 0;
int energia2 = 0;

for (Robo r : robos) {
    if (r.codigo == codigo1) {
        energia1 = r.energia;
    }

    if (r.codigo == codigo2) {
        energia2 = r.energia;
    }
}

if (energia1 == 0) {
    System.out.println("SEGUNDO ROBO VENCEU!");

    for (Robo r : robos) {
        if (r.codigo == codigo1) {
            r.perder();
        }

        if (r.codigo == codigo2) {
            r.vencer();
        }
    }

} else if (energia2 == 0) {
    System.out.println("PRIMEIRO ROBO VENCEU!");

    for (Robo r : robos) {
        if (r.codigo == codigo1) {
            r.vencer();
        }

        if (r.codigo == codigo2) {
            r.perder();
        }
    }

} else if (energia1 > energia2) {
    System.out.println("PRIMEIRO ROBO VENCEU!");

    for (Robo r : robos) {
        if (r.codigo == codigo1) {
            r.vencer();
        }

        if (r.codigo == codigo2) {
            r.perder();
        }
    }

} else if (energia2 > energia1) {
    System.out.println("SEGUNDO ROBO VENCEU!");

    for (Robo r : robos) {
        if (r.codigo == codigo1) {
            r.perder();
        }

        if (r.codigo == codigo2) {
            r.vencer();
        }
    }

} else {
    System.out.println("EMPATE!");

    for (Robo r : robos) {
        if (r.codigo == codigo1) {
            r.empatar();
        }

        if (r.codigo == codigo2) {
            r.empatar();
        }
    }
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
}
