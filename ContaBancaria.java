public class ContaBancaria {

    // Atributos da conta
    int numero;        // número da conta
    String titular;    // nome do dono da conta
    double saldo;      // valor disponível

    // Metodo para depositar dinheiro na conta
    public void depositar(double valor){
        if(valor > 0){ // valida se o valor é válido
            this.saldo += valor; // soma ao saldo
            System.out.println("Depositado com sucesso!");
            System.out.println("Saldo atual: " + this.saldo);
        }
        else {
            System.out.println("Valor invalido!");
        }
    }

    // Metodo para sacar dinheiro da conta
    public void sacar(double valor){
        if(valor > 0 && valor <= this.saldo){ // valida valor e saldo disponível
            this.saldo -= valor; // subtrai do saldo
            System.out.println("Sacado com sucesso!");
            System.out.println("Saldo atual: " + this.saldo);
        }
        else{
            System.out.println("Valor invalido!");
        }
    }

    // Metodo para mostrar os dados da conta
    public void saldo(){
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo atual: " + this.saldo);
    }
}