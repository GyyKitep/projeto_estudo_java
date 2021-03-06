
public class Administrador extends Funcionario implements Autenticavel{     

    private AutenticacaoUtil autenticador;     // compisicao

	public Administrador() {
		this.autenticador = new AutenticacaoUtil();
	}
	
	@Override
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}
	
	@Override
	public boolean autentica(int senha) {
		return this.autenticador.autentica(senha);
	}
	
	public double getBonificacao() {         // nome disso como ? igual o outro metodo se chama reescrita
		System.out.println("Chamando metodo de bonificacao do Gerente");
		return super.getSalario(); //this funcionaria, mas o super da a ideia que o atributo esta definido em outra classe.
	}                                        // Ela pode ser usada em apenas classes que herdam	
}
