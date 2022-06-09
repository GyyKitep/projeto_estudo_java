package br.com.java.io.teste;            //se ele estiver dentro de um diretorio precisa colocar aqui o diretorio

/**
 * Classe que representa um cliente no bytebank.
 * 
 * @author Nico Steppat Geovanny
 * @version 0.1
 */

public class Cliente implements java.io.Serializable {

	private static final long serialVersionUID = -9139439497959581146L; //adicionado por causa da implementação o eclipse pede para adicionar
	                                                 //ele usa essa versao para comparar a versao serializada, se for diferente dispara um erro
												     //a cada serializacao se nao exisite essa definicao um novo UID é gerado
	private String nome;
	private String cpf;
	private String profissao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
		
	
}
