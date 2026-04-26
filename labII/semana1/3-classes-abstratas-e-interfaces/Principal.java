import java.util.Scanner;

// Exercício 2 e 5 - classe de teste
public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ----------------------------------------------------------------
        // Exercício 2 — criar contas via teclado
        // ----------------------------------------------------------------
        System.out.print("Quantas contas deseja criar? ");
        int quantidade = Integer.parseInt(sc.nextLine().trim());

        ContaBancaria[] contas = new ContaBancaria[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\n--- Conta " + (i + 1) + " ---");
            System.out.print("Tipo (1 = ContaCorrente / 2 = ContaPoupanca): ");
            int tipo = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Senha: ");
            String senha = sc.nextLine().trim();

            System.out.print("Saldo inicial: ");
            double saldo = Double.parseDouble(sc.nextLine().trim());

            if (tipo == 1) {
                contas[i] = new ContaCorrente(senha, saldo);
            } else {
                System.out.print("Taxa de rendimento (% ao mês): ");
                double taxa = Double.parseDouble(sc.nextLine().trim());
                contas[i] = new ContaPoupanca(senha, saldo, taxa);
            }
        }

        // Exercício 2 — informar a taxa de rendimento de cada ContaPoupanca
        System.out.println("\n=== Taxas de rendimento das Contas Poupança ===");
        for (ContaBancaria c : contas) {
            if (c instanceof ContaPoupanca) {
                ContaPoupanca cp = (ContaPoupanca) c;
                System.out.println("ContaPoupanca #" + cp.getNumero()
                        + " — taxa: " + cp.getTaxaRendimento() + "% ao mês");
            }
        }

        // Exercício 2 — operações nas contas
        System.out.println("\n=== Operações nas contas ===");
        for (ContaBancaria c : contas) {
            c.deposita(500);
            c.saca(100);
            c.tiraExtrato();
            System.out.println();
        }

        // Exercício 2 — resumo: transações (CC) e taxas (CP)
        System.out.println("=== Resumo ===");
        for (ContaBancaria c : contas) {
            if (c instanceof ContaCorrente) {
                ContaCorrente cc = (ContaCorrente) c;
                System.out.println("ContaCorrente #" + cc.getNumero()
                        + " — transações realizadas: " + cc.getQuantidadeTransacoes());
            } else if (c instanceof ContaPoupanca) {
                ContaPoupanca cp = (ContaPoupanca) c;
                System.out.println("ContaPoupanca #" + cp.getNumero()
                        + " — taxa de rendimento: " + cp.getTaxaRendimento() + "% ao mês");
            }
        }

        // ----------------------------------------------------------------
        // Exercício 5 — array de Rentavel
        // ----------------------------------------------------------------
        System.out.println("\n=== Rendimentos (array de Rentavel) ===");
        Rentavel[] rentaveis = new Rentavel[3];
        rentaveis[0] = new ContaPoupanca("pass", 2000, 0.5);
        rentaveis[1] = new ContaPoupanca("pass", 5000, 0.7);
        rentaveis[2] = new FundoInvestimento("Fundo Renda Fixa", 10000, 12.0);

        for (Rentavel r : rentaveis) {
            System.out.printf("%s => rendimento: R$ %.2f%n", r.toString(), r.calculaRendimento());
        }

        sc.close();
    }
}
