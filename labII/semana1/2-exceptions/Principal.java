/**
 * Exercício 2: main que chama os métodos do Exercício 1.
 * A exceção é lançada e tratada DENTRO dos métodos de Termometro,
 * então o main não precisa de try/catch — o programa nunca é interrompido.
 *
 * Exercício 4: main que chama os métodos do Exercício 3.
 * A exceção se propaga até o main, portanto o main DEVE usar try/catch
 * para evitar que o programa encerre de forma abrupta.
 */
public class Principal {

    public static void main(String[] args) {

        // ----------------------------------------------------------------
        // Exercício 2 — uso de Termometro (exceção tratada dentro do método)
        // Temperatura válida: 0°C a 100°C
        // ----------------------------------------------------------------
        System.out.println("=== Exercício 2 ===");
        Termometro t1 = new Termometro(20.0);

        System.out.println("Temperatura inicial: " + t1.getTemperatura());

        t1.aumentaTemperatura(5.0); // resultado 25°C — válido
        System.out.println("Após aumentar 5.0: " + t1.getTemperatura());

        t1.aumentaTemperatura(200.0); // resultado 225°C — inválido, tratado no método
        System.out.println("Após tentar aumentar 200.0: " + t1.getTemperatura());

        t1.diminuiTemperatura(10.0); // resultado 15°C — válido
        System.out.println("Após diminuir 10.0: " + t1.getTemperatura());

        t1.diminuiTemperatura(50.0); // resultado -35°C — inválido, tratado no método
        System.out.println("Após tentar diminuir 50.0: " + t1.getTemperatura());

        // ----------------------------------------------------------------
        // Exercício 4 — uso de TermometroV2 (exceção propagada até o main)
        // Temperatura válida: 0°C a 100°C
        // ----------------------------------------------------------------
        System.out.println("\n=== Exercício 4 ===");
        TermometroV2 t2 = new TermometroV2(20.0);

        System.out.println("Temperatura inicial: " + t2.getTemperatura());

        // resultado 25°C — válido
        try {
            t2.aumentaTemperatura(5.0);
            System.out.println("Após aumentar 5.0: " + t2.getTemperatura());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: temperatura inválida.\nA temperatura foi mantida em " + t2.getTemperatura());
        }

        // resultado 225°C — inválido, exceção chega ao main
        try {
            t2.aumentaTemperatura(200.0);
            System.out.println("Após tentar aumentar 200.0: " + t2.getTemperatura());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: temperatura inválida.\nA temperatura foi mantida em " + t2.getTemperatura());
        }

        // resultado 15°C — válido
        try {
            t2.diminuiTemperatura(10.0);
            System.out.println("Após diminuir 10.0: " + t2.getTemperatura());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: temperatura inválida.\nA temperatura foi mantida em " + t2.getTemperatura());
        }

        // resultado -35°C — inválido, exceção chega ao main
        try {
            t2.diminuiTemperatura(50.0);
            System.out.println("Após tentar diminuir 50.0: " + t2.getTemperatura());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: temperatura inválida.\nA temperatura foi mantida em " + t2.getTemperatura());
        }
    }
}
