public class Fluxo { 
	public static void main(String[] args) {  // pode ser colocaro aqui a declaracao throws MinhaExcecao
		System.out.println("Ini do main");
		try {
			metodo1();	
		} catch(Exception ex) {          
				String msg = ex.getMessage();
				System.out.println("Exception " + msg);
			  	ex.printStackTrace();
		} 
		System.out.println("Fim do main");
	}
	
	private static void metodo1() throws MinhaExcecao{
		System.out.println("Ini do metodo1");
		metodo2();			
		System.out.println("Fim do metodo1");		
		
	}
	
	private static void metodo2() throws MinhaExcecao {
		System.out.println("Ini do metodo2");
		
		//ArithmeticException ex = new ArithmeticException("deu errado");  // os objetos criados não criados no HEAP - memoria de objetos
		//throw ex; 	//só funciona com classes são extends Throwable 
		
		throw new MinhaExcecao("deu muito errado"); //se a classe for extended da runningtimeexception 
		                                            //caso não precisa declarar na assinatura do metodo
		
		//System.out.println("Fim metodo 2");
		
		
	}
}
