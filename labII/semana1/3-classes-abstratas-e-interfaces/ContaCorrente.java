// Exercício 1 - ContaCorrente
public class ContaCorrente extends ContaBancaria {

    private int quantidadeTransacoes;

    public ContaCorrente(String senha, double saldoInicial) {
        super(senha, saldoInicial);
    }

    @Override
    public void saca(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return;
        }
        if (valor > getSaldo()) {
            System.out.println("Saldo insuficiente para saque de R$ " + valor);
            return;
        }
        setSaldo(getSaldo() - valor);
        quantidadeTransacoes++;
        System.out.println("Saque de R$ " + valor + " realizado. Saldo atual: R$ " + getSaldo());
    }

    @Override
    public void deposita(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
            return;
        }
        setSaldo(getSaldo() + valor);
        quantidadeTransacoes++;
        System.out.println("Depósito de R$ " + valor + " realizado. Saldo atual: R$ " + getSaldo());
    }

    @Override
    public void tiraExtrato() {
        System.out.println("=== Extrato ContaCorrente #" + getNumero() + " ===");
        System.out.println("Saldo:                R$ " + getSaldo());
        System.out.println("Transações realizadas: " + quantidadeTransacoes);
        quantidadeTransacoes++;
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }

    public void setQuantidadeTransacoes(int q) {
        this.quantidadeTransacoes = q;
    }

    @Override
    public String toString() {
        return "ContaCorrente [quantidadeTransacoes=" + quantidadeTransacoes
                + ", " + super.toString() + "]";
    }
}
