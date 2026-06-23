import java.util.ArrayList;
import java.util.Scanner;

public class FolhaPagamento {

    public static void main(String[] args) {

        final double SALARIO_BASE = 2000.00;

        Scanner sc = new Scanner(System.in);

        String nome;
        String matricula;
        double vendas = 0;
        double percentual = 0;

        ArrayList<String> funcionarios = new ArrayList<>();

        int opcao;

        do {

            System.out.println("\n===== SISTEMA FOLHA DE PAGAMENTO =====");
            System.out.println("1 - Cadastrar Funcionário Padrão");
            System.out.println("2 - Cadastrar Funcionário Comissionado");
            System.out.println("3 - Cadastrar Funcionário Produção");
            System.out.println("4 - Gerar Folha de Pagamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Nome: ");
                    nome = sc.nextLine();

                    System.out.print("Matrícula: ");
                    matricula = sc.nextLine();

                    funcionarios.add("PADRAO;" + nome + ";" + matricula);

                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;

                case 2:

                    System.out.print("Nome: ");
                    nome = sc.nextLine();

                    System.out.print("Matrícula: ");
                    matricula = sc.nextLine();


                    do {
                        System.out.print("Valor das vendas: ");
                        vendas = sc.nextDouble();
                    } while (vendas < 0);


                    do {
                        System.out.print("Percentual de comissão: ");
                        percentual = sc.nextDouble();
                    } while (percentual < 0);

                    sc.nextLine();

                    funcionarios.add("COMISSIONADO;" + nome + ";" + matricula
                            + ";" + vendas + ";" + percentual);

                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;

                case 3:

                    System.out.print("Nome: ");
                    nome = sc.nextLine();

                    System.out.print("Matrícula: ");
                    matricula = sc.nextLine();

                    int quantidade;

                    do {
                        System.out.print("Quantidade de peças: ");
                        quantidade = sc.nextInt();
                    } while (quantidade < 0);

                    double valorPeca;

                    do {
                        System.out.print("Valor por peça: ");
                        valorPeca = sc.nextDouble();
                    } while (valorPeca < 0);

                    sc.nextLine();

                    funcionarios.add("PRODUCAO;" + nome + ";" + matricula
                            + ";" + quantidade + ";" + valorPeca);

                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;

                case 4:

                    System.out.println("\n===== FOLHA DE PAGAMENTO =====");
                    System.out.println("Total de pessoas cadastradas: "
                            + funcionarios.size());

                    for (String registro : funcionarios) {

                        String[] dados = registro.split(";");

                        String tipo = dados[0];

                        if (tipo.equals("PADRAO")) {

                            System.out.println("\nNome: " + dados[1]);
                            System.out.println("Matrícula: " + dados[2]);
                            System.out.println("Salário Base: R$ "
                                    + SALARIO_BASE);
                            System.out.println("Extras: R$ 0.00");
                            System.out.println("Salário Final: R$ "
                                    + SALARIO_BASE);

                        } else if (tipo.equals("COMISSIONADO")) {

                            vendas = Double.parseDouble(dados[3]);
                            percentual = Double.parseDouble(dados[4]);

                            double comissao =
                                    vendas * percentual / 100;

                            double salarioFinal =
                                    SALARIO_BASE + comissao;

                            System.out.println("\nNome: " + dados[1]);
                            System.out.println("Matrícula: " + dados[2]);
                            System.out.println("Salário Base: R$ "
                                    + SALARIO_BASE);
                            System.out.println("Comissão: R$ "
                                    + comissao);
                            System.out.println("Salário Final: R$ "
                                    + salarioFinal);

                        } else if (tipo.equals("PRODUCAO")) {

                            quantidade =
                                    Integer.parseInt(dados[3]);

                            valorPeca =
                                    Double.parseDouble(dados[4]);

                            double bonus =
                                    quantidade * valorPeca;

                            double salarioFinal =
                                    SALARIO_BASE + bonus;

                            System.out.println("\nNome: " + dados[1]);
                            System.out.println("Matrícula: " + dados[2]);
                            System.out.println("Salário Base: R$ "
                                    + SALARIO_BASE);
                            System.out.println("Produtividade: R$ "
                                    + bonus);
                            System.out.println("Salário Final: R$ "
                                    + salarioFinal);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida!");

            }

        } while (opcao != 0);

        sc.close();
    }
}
