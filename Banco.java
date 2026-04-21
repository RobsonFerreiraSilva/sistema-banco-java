import java.util.ArrayList;
import java.util.List;

public class Banco {

    // Lista que armazena todas as contas criadas no sistema
    List<ContaBancaria> contas = new ArrayList<>();

    // Metodo para criar uma nova conta
    public void criarConta(String titular, int numero){

        // Cria um novo objeto de conta
        ContaBancaria novaConta = new ContaBancaria();

        // Define os dados da conta
        novaConta.numero = numero;
        novaConta.titular = titular;
        novaConta.saldo = 0; // saldo inicial começa em 0

        // Adiciona a nova conta na lista
        contas.add(novaConta);

        // Mensagem de confirmação
        System.out.println("Conta criada com sucesso!");
    }

    // Metodo para buscar uma conta pelo número
    public ContaBancaria buscarConta(int numero) {

        // Percorre todas as contas da lista
        for (ContaBancaria conta : contas) {

            // Verifica se o número da conta é igual ao informado
            if (conta.numero == numero) {
                return conta; // retorna a conta encontrada
            }
        }

        // Se não encontrar, retorna null
        return null;
    }

    // Metodo para mostrar todas as contas cadastradas
    public void mostrarContas() {

        // Verifica se a lista está vazia
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada!");
        } else {

            // Percorre todas as contas e mostra os dados
            for (ContaBancaria conta : contas) {
                System.out.println("Número da conta: " + conta.numero);
                System.out.println("Titular: " + conta.titular);
                System.out.println("Saldo: " + conta.saldo);
                System.out.println("-------------------------");
            }
        }
    }
}