
public class EditorVideo extends Funcionario{     // extends herda oq tem no funcionario ( O gerente � um funcionario)
	
	public double getBonificacao() {         // nome disso como � igual o outro metodo se chama reescrita
		System.out.println("Chamando metodo de bonificacao do Editor de Video");
		return 150; //this funcionaria, mas o super da a ideia que o atributo esta definido em outra classe.
	}                                        // Ela pode ser usada em apenas classes que herdam	
}
