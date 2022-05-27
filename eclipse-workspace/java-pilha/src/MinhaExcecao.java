
public class MinhaExcecao extends Exception{
	
	//excepction é verificado pelo compilador obriga a colocar a thorw na assinatura do metodo
	// runtimexception é verificado pelo compilador

	public MinhaExcecao(String msg) {
		super(msg);
	}
	
}
