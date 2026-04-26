import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) {
        String nomeArquivo = "produtos.txt";

        Estoque estoque = new Estoque();
        try {
            estoque.preencheEstoque(nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        Produto[] produtos = estoque.getProdutos();

        // a) Alimento mais caro
        Alimento alimentoMaisCaro = null;
        // b) Eletrodoméstico mais barato
        Eletrodomestico eletroMaisBarato = null;

        for (Produto p : produtos) {
            if (p instanceof Alimento) {
                Alimento a = (Alimento) p;
                if (alimentoMaisCaro == null || a.getPreco() > alimentoMaisCaro.getPreco()) {
                    alimentoMaisCaro = a;
                }
            } else if (p instanceof Eletrodomestico) {
                Eletrodomestico e = (Eletrodomestico) p;
                if (eletroMaisBarato == null || e.getPreco() < eletroMaisBarato.getPreco()) {
                    eletroMaisBarato = e;
                }
            }
        }

        // Escreve info.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("info.txt"))) {
            bw.write("=== Informações do Estoque ===");
            bw.newLine();
            bw.newLine();

            // a) Alimento mais caro
            bw.write("a) Alimento mais caro:");
            bw.newLine();
            if (alimentoMaisCaro != null) {
                bw.write("   " + alimentoMaisCaro);
            } else {
                bw.write("   Nenhum alimento encontrado.");
            }
            bw.newLine();
            bw.newLine();

            // b) Eletrodoméstico mais barato
            bw.write("b) Eletrodomestico mais barato:");
            bw.newLine();
            if (eletroMaisBarato != null) {
                bw.write("   " + eletroMaisBarato);
            } else {
                bw.write("   Nenhum eletrodomestico encontrado.");
            }
            bw.newLine();
            bw.newLine();

            // c) Vestuários com estoque
            bw.write("c) Produtos de vestuario (nome e estoque):");
            bw.newLine();
            for (Produto p : produtos) {
                if (p instanceof Vestuario) {
                    Vestuario v = (Vestuario) p;
                    bw.write("   " + v.getNome() + " - estoque: " + v.getQuantidadeEstoque());
                    bw.newLine();
                }
            }

            System.out.println("Arquivo info.txt gerado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever info.txt: " + e.getMessage());
        }
    }
}
