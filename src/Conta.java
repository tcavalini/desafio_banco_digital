

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;

    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;

    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void exibirPropostaCartao(Cliente cliente) {
        double salario = cliente.getSalario();
        int idade = cliente.getIdade();

        if (salario > 5000 && salario <= 10000) {
            double limite = salario * 2;
            System.out.println("Cliente tem cartão disponível com limite de: " + limite);
        } else if (salario > 10000) {  // Corrigido aqui
            double limite = salario * 3;
            System.out.println("Cliente tem cartão disponível com limite de: " + limite);
        } else {
            System.out.println("Cliente não tem cartão disponível.");
        }
        if (idade > 25 && salario <= 35) {
            double limite = salario * 1;
            System.out.println("Cliente tem empréstimo disponível de R$: " + limite);
        } else if (salario > 35) {  // Corrigido aqui
            double limite = salario * 4;
            System.out.println("Cliente tem empréstimo disponível de R$: " + limite);
        } else {
            System.out.println("Cliente não tem crédito disponível para empréstimo.");
        }
    }


    protected void imprimirInfosComuns() {
        System.out.println(String.format("Títular: %s", this.cliente.getNome()));
        System.out.println(String.format("Salário de %.2f", this.cliente.getSalario()));
        System.out.println(String.format("Agência: %d", agencia));
        System.out.println(String.format("Número: %d", numero));
        System.out.println(String.format("Saldo: %.2f", saldo));
    }
}
