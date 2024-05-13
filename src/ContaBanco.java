import java.util.Random;
import java.util.Scanner;

public class ContaBanco {
    private String numConta; // Alteração: Número da conta como String
    private char tipo;
    private String nome;
    private double saldo;
    private boolean status;

    Scanner input = new Scanner(System.in);
    Random gerador = new Random();

    public ContaBanco() {
        this.numConta = ""; // Inicializa como string vazia
        this.saldo = 0.0;
        this.status = false;
    }

    public void abrirConta(char opcao) {
        if (!this.status) {
            this.status = true;
            this.tipo = opcao;

            if (this.tipo == 'c') {
                this.saldo += 50;
            } else if (this.tipo == 'p') {
                this.saldo += 150;
            }

            // Gerar número da conta como string de 6 dígitos
            for (int i = 0; i < 6; i++) {
                this.numConta += gerador.nextInt(10); // Concatena um dígito de 0 a 9
            }
            System.out.println("\nNúmero da sua conta: " + this.numConta + "\n");

        } else {
            System.out.println("Você já tem uma conta!");
        }
    }

    public void fecharConta() {
        if (this.status && this.saldo == 0) { // Fechar apenas se o saldo for zero
            this.status = false;
            System.out.println("Conta fechada com sucesso!");
        } else if (this.saldo > 0) {
            System.out.println("Retire o saldo da conta primeiro.");
        } else {
            System.out.println("Você não possui uma conta.");
        }
    }

    public void depositar(double deposito) {
        if (this.status) {
            this.saldo += deposito;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Você precisa criar uma conta antes!");
        }
    }

    public void sacar(double saque) {
        if (this.status && this.saldo > 0) {
            if (saque <= this.saldo) {
                this.saldo -= saque;
                System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Valor do saque maior que o saldo da conta!");
            }
        } else {
            System.out.println("Você precisa criar uma conta antes!");
        }
    }

    public void menu() {
        System.out.println("***** Banco do Brasil *****");
        System.out.println("Saldo atual: " + this.saldo);
        System.out.println("Escolha uma opção:\n");
        System.out.println("[1] Depositar");
        System.out.println("[2] Sacar");
        System.out.println("[3] Abrir nova conta");
        System.out.println("[4] Fechar conta");
        System.out.println("[0] Sair");
    }

    // Getters e Setters para os atributos
    public String getNumConta() {
        return numConta;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
