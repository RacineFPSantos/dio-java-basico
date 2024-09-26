package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import bancoDigital.main.CaixaDigital;
import exceptions.ParametrosInvalidosException;

public class ContaTerminal {
	// TODO: Conhecer e importar a classe Scanner
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MainMenu();
	}
	
	private static void MainMenu() {
		Integer option = 0;		
		System.out.println("QUAL PROJETO VOCÊ DESEJA VER?");
		
		while (true) {
			try {
				System.out.println("Por favor, qual projeto deseja ver");
				System.out.println("[0] - Conta Banco");
				System.out.println("[1] - Controle de Fluxo");
				System.out.println("[2] - Caixa Digital");
				option  = sc.nextInt();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida! Por favor, insira o número da Agência.");
				sc.nextLine();
			}
		}
		
		while(true) {
			switch(option) {
				case 0: {
					ContaBanco();
					break;
				}
				case 1: {
					DesafioControleFluxo();
					break;
				}
				case 2: {
					CaixaDigital caixaDigital = new CaixaDigital();
					caixaDigital.usarCaixa();
					break;
				}
				default: {
					System.out.println("Tem o que fazer não?");
					break;
				}
			}
		}
	}
	
	private static void ContaBanco() {
		Integer numero = 0;
		String agencia = "";
		String nomeCliente = "";
		double saldo = 0.0;

		// Exibir as mensagens para o nosso usuário
		// Obter pela scanner os valores digitados no Terminal
		System.out.println("Bem-vindo ao Banco JAVA!!");
		
		agencia = inputStringNext(
				"Por favor, digite o número da Agência !", 
				"Entrada inválida! Por favor, insira o número da Agência.");
		
		numero = inputInteger(
				"Por favor, digite o número da conta !", 
				"Entrada inválida! Por favor, insira um número inteiro.");
		
		nomeCliente = inputStringNextLine(
				"Por favor, digite o seu Nome !",
				"Entrada inválida! Por favor, insira um número inteiro."
				);
		
		saldo = inputDouble(
				"Por favor, digite o saldo que deseja depositar !",
				"Entrada inválida! Por favor, insira um número Decimal."
				);

		// Exibir a mensagem conta criada
		System.out.println(
				"Olá " + nomeCliente 
				+ ", \nobrigado por criar uma conta em nosso banco,\nsua agência é "
				+ agencia + ", conta " + numero 
				+ "\ne seu saldo " + saldo + " já está disponível para saque"
		);
	}
	
	//Contador
	private static void DesafioControleFluxo() {
		int parametroUm = inputInteger("Digite o primeiro parâmetro",
				"Entrada inválida! Por favor, insira um número inteiro.");

		int parametroDois = inputInteger("Digite o segundo parâmetro",
				"Entrada inválida! Por favor, insira um número inteiro.");
		
		try {
			//chamando o método contendo a lógica de contagem
			contar(parametroUm, parametroDois);
		
		}catch (ParametrosInvalidosException exception) {
			//imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
			System.out.println("O segundo parâmetro deve ser maior que o primeiro");
		}

	}
	
	private static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
		//validar se parametroUm é MAIOR que parametroDois e lançar a exceção
		if( parametroUm > parametroDois) {
			throw new ParametrosInvalidosException();
		}
		
		int contagem = parametroDois - parametroUm;
		//realizar o for para imprimir os números com base na variável contagem
		
		for (int i = 1; i < contagem + 1; i++) {
			System.out.println(i);
		}
	}
	
	private static int inputInteger(String msg, String erroMsg) {
		int param = 0;
		
		while (true) {
			try {
				System.out.println(msg);
				param = sc.nextInt();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println(erroMsg);
				sc.nextLine();
			}
		}
		
		return param;
	}
	
	private static String inputStringNext(String msg, String erroMsg) {
		String param = "";
		
		while (true) {
			try {
				System.out.println(msg);
				param = sc.next();
				break;
			} catch (InputMismatchException e) {
				System.out.println(erroMsg);
				sc.nextLine();
			}
		}
		
		return param;
	}
	
	private static String inputStringNextLine(String msg, String erroMsg) {
		String param = "";
		
		while (true) {
			try {
				System.out.println(msg);
				param = sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println(erroMsg);
				sc.nextLine();
			}
		}
		
		return param;
	}
	
	private static double inputDouble(String msg, String erroMsg) {
		double param = 0.0;
		
		while (true) {
			try {
				System.out.println(msg);
				param = sc.nextDouble();
				break;
			} catch (InputMismatchException e) {
				System.out.println(erroMsg);
				sc.nextLine();
			}
		}
		
		return param;
	}
}
