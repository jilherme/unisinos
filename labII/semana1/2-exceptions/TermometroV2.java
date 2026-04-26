/**
 * Exercício 3: métodos aumentaTemperatura e diminuiTemperatura
 * LANÇAM a IllegalArgumentException mas NÃO a tratam internamente.
 * A exceção se propaga para quem chamou o método.
 *
 * Regra de validação: a temperatura resultante deve estar entre 0°C e 100°C.
 * Padrão apply → check → rollback (igual à correção).
 */
public class TermometroV2 {

    private double temperatura;

    public TermometroV2(double temperaturaInicial) {
        this.temperatura = temperaturaInicial;
    }

    public double getTemperatura() {
        return temperatura;
    }

    // Exercício 3 — exceção lançada, mas NÃO tratada no método
    public void aumentaTemperatura(double tempMais) throws IllegalArgumentException {
        this.temperatura += tempMais;
        if (this.temperatura < 0 || this.temperatura > 100) {
            this.temperatura -= tempMais;
            throw new IllegalArgumentException();
        }
    }

    // Exercício 3 — exceção lançada, mas NÃO tratada no método
    public void diminuiTemperatura(double tempMenos) throws IllegalArgumentException {
        this.temperatura -= tempMenos;
        if (this.temperatura < 0 || this.temperatura > 100) {
            this.temperatura += tempMenos;
            throw new IllegalArgumentException();
        }
    }
}
