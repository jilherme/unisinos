// Exercício 1 e 3 - ContaPoupanca implementa Rentavel
public class ContaPoupanca extends ContaBancaria implements Rentavel {

    private double taxaRendimento; // percentual, ex: 0.5 = 0,5% ao mês

    public ContaPoupanca(String senha, double saldoInicial, double taxaRendimento) {
        super(senha, saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    public ContaPoupanca(String senha) {
        super(senha);
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
        System.out.println("Saque de R$ " + valor + " realizado. Saldo atual: R$ " + getSaldo());
    }

    @Override
    public void deposita(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
            return;
        }
        setSaldo(getSaldo() + valor);
        System.out.println("Depósito de R$ " + valor + " realizado. Saldo atual: R$ " + getSaldo());
    }

    @Override
    public void tiraExtrato() {
        System.out.println("=== Extrato ContaPoupanca #" + getNumero() + " ===");
        System.out.println("Saldo:              R$ " + getSaldo());
        System.out.println("Taxa de rendimento: " + taxaRendimento + "% ao mês");
        System.out.printf("Rendimento mês:     R$ %.2f%n", calculaRendimento());
    }

    // Exercício 3 — implementação de Rentavel
    @Override
    public double calculaRendimento() {
        return getSaldo() * (taxaRendimento / 100);
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public String toString() {
        return "ContaPoupanca [taxaRendimento=" + taxaRendimento
                + ", " + super.toString() + "]";
    }
}
