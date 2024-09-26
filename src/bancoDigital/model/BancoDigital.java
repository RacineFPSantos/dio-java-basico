package bancoDigital.model;

import java.util.ArrayList;
import java.util.List;

public class BancoDigital {
	private String nome;	
	private List<Conta> contas = new ArrayList<Conta>();
	
	public String adicionarNovaConta(Conta novaConta) {
		
		if(!verificaSeExisteConta(novaConta)) {
			contas.add(novaConta);
			return "Conta adicionada com sucesso";		
		} else {
			return "Conta já existe";
		}
	}
	
	
	private boolean verificaSeExisteConta(Conta _conta) {
		boolean exists = contas.stream()
                .anyMatch(conta -> conta.equals(_conta));
		
		return exists;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
