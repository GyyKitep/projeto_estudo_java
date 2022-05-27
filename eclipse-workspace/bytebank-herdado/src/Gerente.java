
public class Gerente extends Funcionario implements Autenticavel{ 

	private AutenticacaoUtil autenticador;    // compisicao

	public Gerente() {
		this.autenticador = new AutenticacaoUtil();
	}
	
	public double getBonificacao() {         // nome disso como é igual o outro metodo se chama reescrita
		System.out.println("Chamando metodo de bonificacao do Gerente");
		return super.getSalario(); //this funcionaria, mas o super da a ideia que o atributo esta definido em outra classe.
	}                                        // Ela pode ser usada em apenas classes que herdam	
	
	@Override
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}
	
	@Override
	public boolean autentica(int senha) {
		return this.autenticador.autentica(senha);
	}


}
