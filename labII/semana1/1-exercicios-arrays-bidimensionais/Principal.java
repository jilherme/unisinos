public class Principal {

    public static void main(String[] args) {
        ExerciciosArrays exercicios = new ExerciciosArrays();

        System.out.println("Exercicio 1a:");
        imprimirMatrizInt(exercicios.exercicio1a());

        System.out.println("\nExercicio 1b:");
        imprimirMatrizInt(exercicios.exercicio1b());

        System.out.println("\nExercicio 1c:");
        imprimirMatrizInt(exercicios.exercicio1c());

        System.out.println("\nExercicio 1d:");
        imprimirMatrizInt(exercicios.exercicio1d());

        System.out.println("\nExercicio 2:");
        int[][] matrizEx2 = exercicios.exercicio2();
        imprimirMatrizInt(matrizEx2);

        System.out.println("\nExercicio 3:");
        double[][] matrizEx3 = exercicios.exercicio3();
        imprimirMatrizDouble(matrizEx3);

        int quantidadeElementos = exercicios.exercicio4_e_5(matrizEx3);
        System.out.println("\nExercicio 4 (quantidade de elementos): " + quantidadeElementos);
        System.out.println("Exercicio 5 (quantidade de elementos): " + quantidadeElementos);

        System.out.println("\nExercicio 6 (formatacao com hifen):");
        System.out.println(exercicios.exercicio6(matrizEx3));

        System.out.println("\nExercicio 7 (maior valor): " + exercicios.exercicio7(matrizEx3));
        System.out.println("Exercicio 8 (soma da matriz de inteiros): " + exercicios.exercicio8(matrizEx2));
        System.out.println("Exercicio 9 (media dos valores): " + exercicios.exercicio9(matrizEx3));

        System.out.println("\nExercicio 10:");
        char[][] matrizEx10 = exercicios.exercicio10();
        imprimirMatrizChar(matrizEx10);

        System.out.println("\nExercicio 11 (apenas positivos da matriz do exercicio 2):");
        int[] positivos = exercicios.exercicio11(matrizEx2);
        imprimirArrayInt(positivos);
    }

    private static void imprimirMatrizInt(int[][] matriz) {
        for (int[] linha : matriz) {
            for (int valor : linha) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }

    private static void imprimirMatrizDouble(double[][] matriz) {
        for (double[] linha : matriz) {
            for (double valor : linha) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }

    private static void imprimirMatrizChar(char[][] matriz) {
        for (char[] linha : matriz) {
            for (char valor : linha) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }

    private static void imprimirArrayInt(int[] array) {
        for (int valor : array) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}