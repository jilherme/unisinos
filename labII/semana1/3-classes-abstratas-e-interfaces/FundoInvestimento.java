// Exercício 4 - outro objeto que implementa Rentavel
public class FundoInvestimento implements Rentavel {

    private String nome;
    private double valorInvestido;
    private double taxaRendimentoAnual; // percentual, ex: 12.0 = 12% ao ano

    public FundoInvestimento(String nome, double valorInvestido, double taxaRendimentoAnual) {
        this.nome = nome;
        this.valorInvestido = valorInvestido;
        this.taxaRendimentoAnual = taxaRendimentoAnual;
    }

    @Override
    public double calculaRendimento() {
        return valorInvestido * (taxaRendimentoAnual / 100);
    }

    public String getNome() {
        return nome;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public double getTaxaRendimentoAnual() {
        return taxaRendimentoAnual;
    }

    @Override
    public String toString() {
        return "FundoInvestimento [" + nome + ", investido: R$ " + valorInvestido
                + ", taxa: " + taxaRendimentoAnual + "% a.a.]";
    }
}
