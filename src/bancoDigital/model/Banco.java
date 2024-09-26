package bancodigital.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {
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
	
	public Optional<Conta> bancoFindByNomeCliente(String nomeCliente) {
		Optional<Conta> contaEncontrada = contas.stream()
                .filter(conta -> conta.getCliente().getNome().equals(nomeCliente)) 
                .findFirst();
		
		if(contaEncontrada.isPresent()) {
			return contaEncontrada;
		} else {
			return null;
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
