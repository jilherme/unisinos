import java.util.Scanner;

// Exercício 1 - superclasse abstrata
public abstract class ContaBancaria {

    private String senha;
    private int numero;
    private double saldo;

    public ContaBancaria(String senha) {
        this.senha = senha;
        this.numero = (int) (Math.random() * 10000 + 1);
    }

    public ContaBancaria(String senha, double saldo) {
        this(senha);
        this.saldo = saldo;
    }

    // métodos abstratos — cada subclasse implementa do seu jeito
    public abstract void saca(double valor);

    public abstract void deposita(double valor);

    public abstract void tiraExtrato();

    // método concreto — confirma a senha antiga pelo teclado antes de alterar
    public boolean alteraSenha(String novaSenha) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a senha atual para confirmação: ");
        String senhaInformada = sc.nextLine();
        if (senhaInformada.equals(this.senha)) {
            this.senha = novaSenha;
            System.out.println("Senha alterada com sucesso.");
            return true;
        }
        System.out.println("Senha incorreta. A senha não foi alterada.");
        return false;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaBancaria [numero=" + numero + ", saldo=" + saldo + "]";
    }
}
