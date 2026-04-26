/**
 * Exercício 1: métodos aumentaTemperatura e diminuiTemperatura
 * lançam E TRATAM (catch) a IllegalArgumentException internamente.
 *
 * Regra de validação: a temperatura resultante deve estar entre 0°C e 100°C.
 * Padrão apply → check → rollback (igual à correção).
 */
public class Termometro {

    private double temperatura;

    public Termometro(double temperaturaInicial) {
        this.temperatura = temperaturaInicial;
    }

    public double getTemperatura() {
        return temperatura;
    }

    // Exercício 1 — exceção lançada e tratada dentro do próprio método
    public void aumentaTemperatura(double tempMais) {
        try {
            this.temperatura += tempMais;
            if (this.temperatura < 0 || this.temperatura > 100)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            this.temperatura -= tempMais;
            System.out.println("Erro: temperatura inválida.\nA temperatura foi mantida em " + this.temperatura);
        }
    }

    // Exercício 1 — exceção lançada e tratada dentro do próprio método
    public void diminuiTemperatura(double tempMenos) {
        try {
            this.temperatura -= tempMenos;
            if (this.temperatura < 0 || this.temperatura > 100)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            this.temperatura += tempMenos;
            System.out.println("Erro: temperatura inválida.\nA temperatura foi mantida em " + this.temperatura);
        }
    }
}
