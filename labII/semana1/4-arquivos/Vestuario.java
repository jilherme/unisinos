public class Vestuario extends Produto {

    private int quantidadeEstoque;

    public Vestuario(String nome, String descricao, double preco, int quantidadeEstoque) {
        super(nome, descricao, preco);
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "[Vestuario] " + super.toString() + " | Estoque: " + quantidadeEstoque;
    }
}
