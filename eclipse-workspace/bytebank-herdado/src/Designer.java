
public class Designer extends Funcionario{     // extends herda oq tem no funcionario ( O gerente � um funcionario)
	
											 // como o na classe pai o metodo bonifica foi declarado como abstract o filho � orbigado a declarar o 
	                                         // metodo bonifica ou declara a classe como abstracte
	
	public double getBonificacao() {         // nome disso como � igual o outro metodo se chama reescrita
		System.out.println("Chamando metodo de bonificacao do Designer");
		return 200; //this funcionaria, mas o super da a ideia que o atributo esta definido em outra classe.
	}                                        // Ela pode ser usada em apenas classes que herdam
	
}
