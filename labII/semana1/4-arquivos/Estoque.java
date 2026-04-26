import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private Produto[] produtos;

    public Produto[] getProdutos() {
        return produtos;
    }

    public void preencheEstoque(String nomeArquivo) throws IOException {
        // Lê todas as linhas (exceto o cabeçalho) para descobrir o tamanho
        List<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            br.readLine(); // descarta o cabeçalho
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    linhas.add(linha);
                }
            }
        }

        produtos = new Produto[linhas.size()];

        for (int i = 0; i < linhas.size(); i++) {
            String[] partes = linhas.get(i).split(" \\* ");
            String nome = partes[0].trim();
            String descricao = partes[1].trim();
            double preco = Double.parseDouble(partes[2].trim());
            String tipo = partes[3].trim();
            String infoExtra = partes[4].trim();

            switch (tipo) {
                case "Alimento":
                    produtos[i] = new Alimento(nome, descricao, preco, infoExtra);
                    break;
                case "Vestuario":
                    produtos[i] = new Vestuario(nome, descricao, preco, Integer.parseInt(infoExtra));
                    break;
                case "Eletrodomestico":
                    produtos[i] = new Eletrodomestico(nome, descricao, preco, Double.parseDouble(infoExtra));
                    break;
                default:
                    System.out.println("Tipo desconhecido: " + tipo);
            }
        }
    }
}
