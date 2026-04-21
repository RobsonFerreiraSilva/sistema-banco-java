import java.util.Scanner;

public class Main {
    static void main() { // metodo principal (no padrão Java seria public static void main(String[] args))

        Scanner sc = new Scanner(System.in); // objeto para ler dados do usuário

        Banco banco = new Banco(); // cria o sistema do banco (onde ficam as contas)

        int opcao = 0; // variável para controlar o menu

        // loop do menu, roda até o usuário escolher sair (6)
        while (opcao != 6) {
            System.out.println("-------- Menu --------");
            System.out.println("1 - Criar conta: ");
            System.out.println("2 - Deposito: ");
            System.out.println("3 - Sacar: ");
            System.out.println("4 - Consultar Saldo: ");
            System.out.println("5 - Mostrar Contas: ");
            System.out.println("6 - Sair: ");

            opcao = sc.nextInt(); // lê a opção
            sc.nextLine(); // limpa o ENTER

            switch (opcao) {

                case 1:
                    // criação de conta
                    System.out.println("Digite seu nome: ");
                    String titular = sc.nextLine(); // lê nome

                    System.out.println("Digite sua conta: ");
                    int numero = sc.nextInt(); // lê número da conta
                    sc.nextLine(); // limpa ENTER

                    banco.criarConta(titular, numero); // chama metodo no banco
                    break;

                case 2:
                    // depósito
                    System.out.println("Digite o número da conta:");
                    int numConta = sc.nextInt();
                    sc.nextLine();

                    // busca a conta na lista
                    ContaBancaria contaDeposito = banco.buscarConta(numConta);

                    if (contaDeposito != null) { // verifica se encontrou
                        System.out.println("Digite o valor a ser depositado:");
                        double valor = sc.nextDouble();
                        sc.nextLine();

                        contaDeposito.depositar(valor); // deposita na conta encontrada
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 3:
                    // saque
                    System.out.println("Digite o numero da conta: ");
                    int numContaSaque = sc.nextInt();
                    sc.nextLine();

                    ContaBancaria contaSacar = banco.buscarConta(numContaSaque);

                    if (contaSacar != null) {
                        System.out.println("Digite o valor a ser sacado:");
                        double valorSaque = sc.nextDouble();
                        sc.nextLine();

                        contaSacar.sacar(valorSaque); // chama saque da conta
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 4:
                    // consultar saldo
                    System.out.println("Digite o numero da conta: ");
                    int numSaldo = sc.nextInt();
                    sc.nextLine();

                    ContaBancaria contaSaldo = banco.buscarConta(numSaldo);

                    if (contaSaldo != null) {
                        contaSaldo.saldo(); // mostra dados da conta
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 5:
                    // mostra todas as contas cadastradas
                    banco.mostrarContas();
                    break;

                case 6:
                    // saída do sistema
                    System.out.println("Saindo da sua conta, Obrigado");
                    break;

                default:
                    // opção inválida
                    System.out.println("Opção inválida");
            }
        }
    }
}