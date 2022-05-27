
public abstract class Funcionario {    // abstract é usado para quando é herança esta classe não pode ser instanciada

	private String nome;
	private String cpf;
	//protected double salario;           //protected -> publico para os extends 
	private double salario;
	
	public abstract double getBonificacao(); //metodo sem corpo só funciona como chamado, mas não faz nada ele serve para as classes filhas poderem usar
	
	
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
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	
}
