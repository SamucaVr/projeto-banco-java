import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        ContaBanco conta1 = new ContaBanco();
        Scanner input = new Scanner(System.in);
        int opcao;
        char opcaoC;
        double valor = 0;

        do {
            Thread.sleep(3000);
            conta1.menu();
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor que deseja depositar:");
                    valor = input.nextDouble();
                    conta1.depositar(valor);
                    break;
                case 2:
                    System.out.println("Digite o valor que deseja sacar:");
                    valor = input.nextDouble();
                    conta1.sacar(valor);
                    break;
                case 3:
                    System.out.println("Digite o tipo de conta (c = corrente, p = poupança):");
                    opcaoC = input.next().charAt(0);

                    if (opcaoC == 'c' || opcaoC == 'p') {
                        conta1.abrirConta(opcaoC);
                    } else {
                        System.out.println("Opção Inválida!");
                    }
                    break;
                case 4:
                    conta1.fecharConta();
                    break;
                case 0:
                    System.out.println("Desligando...");
                    break;
                default:
                    System.out.println("Opção Inválida! Tente outra opção");
            }
        } while (opcao != 0);

        input.close();
    }
}
