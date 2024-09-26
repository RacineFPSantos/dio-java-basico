package bancoDigital.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import bancoDigital.model.BancoDigital;
import bancoDigital.model.Cliente;
import bancoDigital.model.Conta;
import bancoDigital.model.ContaCorrente;
import bancoDigital.model.ContaPoupanca;

public class CaixaDigital {
	private static Scanner sc = new Scanner(System.in);
	private BancoDigital bancoDigital= null;
	
	public CaixaDigital () {
		bancoDigital = new BancoDigital();
	}
	
	public void usarCaixa() {
		System.out.println("Bem-vindo ao Banco Comunitário?");
		Integer option = 0;	
		
		while (true) {
			try {
				System.out.println("Por favor, qual opção deseja usar");
				System.out.println("[0] - Criar Conta Corrente");
				System.out.println("[1] - Criar Conta Poupança");
				System.out.println("[2] - Testar Caixa");
				option  = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida! Por favor, insira o número da Agência.");
				sc.nextLine();
			}

			switch(option) {
				case 0: {
					CriarContaCorrente();
					break;
				}
				case 1: {
					CriarContaPoupanca();
					break;
				}
				case 2: {
					BancoTeste();
					break;
				}
				default: {
					System.out.println("Tem o que fazer não?");
					break;
				}
			}
		}
		
	}
	
	private void BancoTeste() {
		Cliente cliente = CriarNovoCliente();
		cliente.setNome("Racine Santos");
		//verifica se já tem conta
		
		
		//Criar conta cliente
		
		Conta cc = new ContaCorrente(cliente);
		cc.depositar(100);
		
		Conta cp = new ContaPoupanca(cliente);
		cc.transferir(75, cp);
		
		cc.imprimirExtrato();
		System.out.println("");
		
		cp.imprimirExtrato();		
		System.out.println("");
		System.out.println("");
	}
	
	private void CriarContaCorrente() {
		Cliente cliente = CriarNovoCliente();		
		Conta cc = new ContaCorrente(cliente);
		
		bancoDigital.
		cc.imprimirExtrato();
	}
	
	private void CriarContaPoupanca() {
		Cliente cliente = CriarNovoCliente();
		
		Conta cp = new ContaPoupanca(cliente);
		cp.imprimirExtrato();	
	}
	
	private Cliente CriarNovoCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome(inputStringNext("Digite o seu nome.", "Formato de nome incorreto"));
		
		return cliente;
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
