public class Main {
    public static void main(String[] args) {

        Cliente eduardo = new Cliente("Eduardo");
        Cliente juliana = new Cliente("Juliana");


        Conta cc = new ContaCorrente(eduardo);
        Conta poupanca = new ContaPoupanca(juliana);

        cc.depositar(100);
        cc.transferir(poupanca, 20);

        poupanca.sacar(10);

        cc.imprimirExtrato();

        System.out.println();

        poupanca.imprimirExtrato();
    }
}
