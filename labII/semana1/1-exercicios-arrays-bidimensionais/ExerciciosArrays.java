import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ExerciciosArrays {

    private final Scanner scanner;
    private final Random random;

    public ExerciciosArrays() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public int[][] exercicio1a() {
        int[][] matriz = new int[3][10];

        for (int[] linha : matriz) {
            for (int j = 0; j < linha.length; j++) {
                linha[j] = j;
            }
        }

        return matriz;
    }

    public int[][] exercicio1b() {
        int[][] matriz = new int[5][10];

        for (int[] linha : matriz) {
            for (int j = 0; j < linha.length; j++) {
                linha[j] = j * j;
            }
        }

        return matriz;
    }

    public int[][] exercicio1c() {
        int[][] matriz = new int[6][6];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = i;
            }
        }

        return matriz;
    }

    public int[][] exercicio1d() {
        int[][] matriz = new int[9][6];

        for (int i = 0; i < matriz.length; i++) {
            int valor = (i % 2 == 0) ? -1 : 0;
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = valor;
            }
        }

        return matriz;
    }

    public int[][] exercicio2() {
        int linhas = lerInteiroMaiorQueZero("Exercicio 2 - Informe o numero de linhas: ");
        int colunas = lerInteiroMaiorQueZero("Exercicio 2 - Informe o numero de colunas: ");

        int[][] matriz = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = random.nextInt(100);
            }
        }

        return matriz;
    }

    public double[][] exercicio3() {
        double[][] matriz = new double[2][5];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = lerDouble("Exercicio 3 - Informe o valor para [" + i + "][" + j + "]: ");
            }
        }

        return matriz;
    }

    public int exercicio4_e_5(double[][] matriz) {
        int quantidade = 0;

        for (double[] linha : matriz) {
            quantidade += linha.length;
        }

        return quantidade;
    }

    public String exercicio6(double[][] matriz) {
        StringBuilder saida = new StringBuilder();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                saida.append(matriz[i][j]);
                if (j < matriz[i].length - 1) {
                    saida.append(" - ");
                }
            }
            if (i < matriz.length - 1) {
                saida.append(System.lineSeparator());
            }
        }

        return saida.toString();
    }

    public double exercicio7(double[][] matriz) {
        validarMatrizNaoVazia(matriz);

        double maior = matriz[0][0];
        for (double[] linha : matriz) {
            for (double valor : linha) {
                if (valor > maior) {
                    maior = valor;
                }
            }
        }

        return maior;
    }

    public int exercicio8(int[][] matriz) {
        int soma = 0;

        for (int[] linha : matriz) {
            for (int valor : linha) {
                soma += valor;
            }
        }

        return soma;
    }

    public double exercicio9(double[][] matriz) {
        int quantidade = exercicio4_e_5(matriz);
        if (quantidade == 0) {
            return 0.0;
        }

        double soma = 0.0;
        for (double[] linha : matriz) {
            for (double valor : linha) {
                soma += valor;
            }
        }

        return soma / quantidade;
    }

    public char[][] exercicio10() {
        int linhas = random.nextInt(5) + 1;
        int colunas = random.nextInt(3) + 1;

        System.out.println("Exercicio 10 - Tamanho gerado: " + linhas + "x" + colunas);

        char[][] matriz = new char[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = lerCaractere("Exercicio 10 - Informe o caractere para [" + i + "][" + j + "]: ");
            }
        }

        return matriz;
    }

    public int[] exercicio11(int[][] matriz) {
        List<Integer> positivos = new ArrayList<>();

        for (int[] linha : matriz) {
            for (int valor : linha) {
                if (valor > 0) {
                    positivos.add(valor);
                }
            }
        }

        int[] resultado = new int[positivos.size()];
        for (int i = 0; i < positivos.size(); i++) {
            resultado[i] = positivos.get(i);
        }

        return resultado;
    }

    private int lerInteiroMaiorQueZero(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine();

            try {
                int valor = Integer.parseInt(entrada.trim());
                if (valor > 0) {
                    return valor;
                }
                System.out.println("Digite um inteiro maior que zero.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Digite um numero inteiro.");
            }
        }
    }

    private double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim().replace(',', '.');

            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Digite um numero decimal.");
            }
        }
    }

    private char lerCaractere(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine();

            if (!entrada.isEmpty()) {
                return entrada.charAt(0);
            }
            System.out.println("Entrada invalida. Digite ao menos um caractere.");
        }
    }

    private void validarMatrizNaoVazia(double[][] matriz) {
        if (matriz.length == 0 || matriz[0].length == 0) {
            throw new IllegalArgumentException("A matriz nao pode ser vazia.");
        }
    }
}