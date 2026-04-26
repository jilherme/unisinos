public class Eletrodomestico extends Produto {

    private double ipi; // valor adicional de IPI em reais

    public Eletrodomestico(String nome, String descricao, double preco, double ipi) {
        super(nome, descricao, preco);
        this.ipi = ipi;
    }

    public double getIpi() {
        return ipi;
    }

    @Override
    public String toString() {
        return "[Eletrodomestico] " + super.toString() + " | IPI: R$ " + String.format("%.2f", ipi);
    }
}
