public abstract class Conta implements IConta {

    private static final Integer AGENCIA_PADRAO = 3843;
    private static Integer SEQUENCIAL = 1;

    private Integer agencia;
    private Integer numero;
    private Double saldo;

    private Cliente cliente;


    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.saldo = 0D;
        this.cliente = cliente;
    }

    @Override
    public void depositar(double valor){
        this.saldo += valor;
    }

    @Override
    public void sacar(double valor){
        if(saldo <= 0 || (saldo - valor) < 0){
            System.out.println("Saldo insuficiente");
        } else {
            this.saldo -= valor;

        }
    }

    @Override
    public void transferir(Conta contaDestino, double valor){
        if(saldo <= 0 || (saldo - valor) < 0){
            System.out.println("Saldo insuficiente");
        } else {
            this.sacar(valor);
            contaDestino.depositar(valor);

        }
    }

    protected void infoComuns(){
        System.out.println(String.format("Titular: %s", getCliente().getNome()));
        System.out.println(String.format("Agencia: %d", getAgencia()));
        System.out.println(String.format("Numero: %d", getNumero()));
        System.out.println(String.format("Saldo: %.2f", getSaldo()));
    }


    public Integer getAgencia() {
        return agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
