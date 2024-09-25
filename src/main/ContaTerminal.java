package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaTerminal {
	// TODO: Conhecer e importar a classe Scanner
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Integer numero = 0;
		String agencia = "";
		String nomeCliente = "";
		double saldo = 0.0;

		// Exibir as mensagens para o nosso usuário
		// Obter pela scanner os valores digitados no Terminal
		System.out.println("Bem-vindo ao Banco JAVA!!");

		while (true) {
			try {
				System.out.println("Por favor, digite o número da Agência !");
				agencia = sc.next();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida! Por favor, insira o número da Agência.");
				sc.nextLine();
			}
		}

		while (true) {
			try {
				System.out.println("Por favor, digite o número da conta !");
				numero = sc.nextInt();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
				sc.nextLine();
			}
		}

		while (true) {
			try {
				System.out.println("Por favor, digite o seu Nome !");
				nomeCliente = sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
				sc.nextLine();
			}
		}

		while (true) {
			try {
				System.out.println("Por favor, digite o saldo que deseja depositar !");
				saldo = sc.nextDouble();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida! Por favor, insira um número Decimal.");
				sc.nextLine();
			}
		}

		// Exibir a mensagem conta criada
		System.out.println("Olá " + nomeCliente + ", \nobrigado por criar uma conta em nosso banco,\nsua agência é "
				+ agencia + ", conta " + numero + "\ne seu saldo " + saldo + " já está disponível para saque");
	}

}
