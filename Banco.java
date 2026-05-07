import java.util.ArrayList;
import java.util.List;

public class Banco {

    // Lista que armazena todas as contas criadas no sistema
    List<ContaBancaria> contas = new ArrayList<>();

    // Metodo para criar uma nova conta
    public void criarConta(String titular, int numero){

        // Cria um novo objeto de conta
        ContaBancaria novaConta = new ContaBancaria(numero, titular, 0);

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
            if (conta.getNumero() == numero) {
                return conta; // retorna a conta encontrada
            }
        }

        // Se não encontrar, retorna null
        return null;
    }

    public void transferir(int origem, int destino, double valor){
        ContaBancaria contaOrigem = buscarConta(origem);
        ContaBancaria contaDestino = buscarConta(destino);

        if (valor <= 0){
            System.out.println("Valor invalido!");
            return;
        }

        if (origem == destino) {
            System.out.println("Não é possível transferir para a mesma conta");
            return;
        }

        if (contaOrigem == null || contaDestino == null){
            System.out.println("Conta inexistente!");
        }
        else if (contaOrigem.getSaldo() >= valor){
            contaOrigem.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferencia realizada com sucesso!");
        }
        else {
            System.out.println("Saldo insuficiente!");
        }
    }

    // Metodo para mostrar todas as contas cadastradas
    public void mostrarContas() {

        // Verifica se a lista está vazia
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada!");
        } else {

            // Percorre todas as contas e mostra os dados
            for (ContaBancaria conta : contas) {
                System.out.println("Número da conta: " + conta.getNumero());
                System.out.println("Titular: " + conta.getTitular());
                System.out.println("Saldo: " + conta.getSaldo());
                System.out.println("-------------------------");
            }
        }
    }
}