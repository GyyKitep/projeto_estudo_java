// ArithmeticException é uma classe 


public class FluxoComTratamento2 {    // pilha de execucao
	public static void main(String[] args) {
		System.out.println("Ini do main");
		try {
			metodo1();	
		} catch(ArithmeticException | NullPointerException ex) {          
				String msg = ex.getMessage();
				System.out.println("Exception " + msg);
			  	ex.printStackTrace();
		} //catch(NullPointerException ex) {
		  //String msg = ex.getMessage();
		  //System.out.println("NullPointerException" + msg);
		  //ex.printStackTrace();
		//}
			
		System.out.println("Fim do main");
	}
	
	private static void metodo1() {
		System.out.println("Ini do metodo1");

//		try {
			metodo2();	
//			} catch(ArithmeticException ex) {          
//			System.out.println("ArithmeticException");
//		}
		
		System.out.println("Fim do metodo1");		
		
	}
	
	private static void metodo2() {
		System.out.println("Ini do metodo2");
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
			
			// se não tratar a exceção o codigo busca alguem que trate e vai abortando os metodos
//			try {               // executa um codigo potenciamente perigoso ( pode dar erro)
				int a = i / 0;                           
//			} catch(ArithmeticException ex) {           // captura o erro ou a exeção
//				System.out.println("ArithmeticException");
//			}
			 
//			Conta cc = null;
			
//			cc.deposita();
			
		}
		
		System.out.println("Fim metodo 2");
		
		
	}
}
