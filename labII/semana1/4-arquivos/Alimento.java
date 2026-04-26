public class Alimento extends Produto {

    private String dataValidade; // formato dd/mm/aaaa

    public Alimento(String nome, String descricao, double preco, String dataValidade) {
        super(nome, descricao, preco);
        this.dataValidade = dataValidade;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    @Override
    public String toString() {
        return "[Alimento] " + super.toString() + " | Validade: " + dataValidade;
    }
}
