//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente thiago = new Cliente();
        thiago.setNome("Thiago Cavalini");
        thiago.setSalario(2000);
        Conta cc = new ContaCorrente(thiago);
        Conta poupanca = new ContaPoupanca(thiago);


        cc.depositar(100);
        cc.transferir(70, poupanca);
        cc.imprimirExtrato();
        cc.exibirPropostaCartao(thiago);
        poupanca.imprimirExtrato();
    }
}