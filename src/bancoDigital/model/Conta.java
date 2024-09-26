package bancodigital.model;

import bancodigital.interfaces.IConta;

public abstract class Conta implements IConta{
	private static final int AGENCIA_PADRAO = 0001;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
		
	protected Cliente cliente;	
	
	public Conta (Cliente cliente) {
		agencia = AGENCIA_PADRAO;
		numero = SEQUENCIAL++;
		saldo = 0.0;
	}
	
	@Override
	public void sacar(double valor) {
		saldo -= valor;		
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);		
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Agencia: %d: ", agencia));
		System.out.println(String.format("Número: %d: ", numero));
		System.out.println(String.format("Saldo: %.2f: ", saldo));
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
}
