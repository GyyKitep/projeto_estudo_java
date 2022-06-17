package br.com.projeto;

public class Aluno {
	private String nome;
	private int numeroMatricula;

	public Aluno(String nome, int numeroMatricula) {
		if(nome == null) {
			throw new NullPointerException("nome nao pode ser null");
		}
		
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroMatricula() {
		return numeroMatricula;
	}
	
	@Override
	public String toString() {
		return "[Aluno: " + this.nome + " Matricula: " + this.numeroMatricula + "]";
	}
	
	@Override
	public boolean equals(Object obj) {    		//sempre que reescrever o equals precisa reescrever o hashcode 
		Aluno outro = (Aluno) obj;		
		return this.nome.equals(outro.nome);
	}
	
	@Override
	public int hashCode() {
//		return this.nome.charAt(0);   //definicao do identificador para encontrar os registros 
//									  //no exemplo ele para buscar ele busca pelo primeiro caracter do nome ate achar o que esta procurando
		return this.nome.hashCode();  //ele olha o nome inteiro
	}

}
