
public class TesteReferencias {
	public static void main(String[] args) {
		
		//Funcionario g1 = new Gerente();  // Gerente g1 = new Funcionario() n�o funciona, pois nem todo funcionario � gerente
										 // Referencia funcionario (ela pode mudar, o tipo n�o) do tipo gerente 
		//g1.autentifica(2000); -> nao funciona
		
	
		Gerente g1 = new Gerente();	
		g1.setNome("Marcos");
		g1.setSalario(5000.0);
				
		EditorVideo ev1 = new EditorVideo();
		ev1.setSalario(2500.0);
		
		Designer d1 = new Designer();
		d1.setSalario(2000.0);
       
		ControleBonificacao controle = new ControleBonificacao();
		
		controle.registra(g1);       // n�o da problema na compila��o pois esta sendo usado a referencia mais generica que � o funcionario
		controle.registra(ev1);
		controle.registra(d1);
		
		System.out.println(controle.getSoma());
	
	}
}
