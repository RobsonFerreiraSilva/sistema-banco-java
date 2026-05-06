public class ContaBancaria {

    // Atributos da conta
    private int numero;        // número da conta
    private String titular;    // nome do dono da conta
    private double saldo;      // valor disponível

    public ContaBancaria(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }


    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }


    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numero=" + numero +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }

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
        if (valor <= 0){
            System.out.println("Valor invalido!");
        }
        else if (valor > this.saldo){
            System.out.println("Saldo insuficiente!");
        }
        else{
            this.saldo -= valor;
            System.out.println("Sacado com sucesso");
            System.out.println("Saldo atual: " + this.saldo);
        }
    }

    // Metodo para mostrar os dados da conta
    public void saldo(){
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo atual: " + this.saldo);
    }
}