
public class Conexao implements AutoCloseable{
	
	//IllegalStateException e IllegalArgumentException s�o erros importantes para retornar 
	
	public Conexao() {
		System.out.println("Abrindo conex�o");
		//throw new IllegalStateException("Deu erro na Conex�o");	
	}
	
	public void leDados() {
		System.out.println("Recebendo Dados");
		throw new IllegalStateException("Deu erro na Conex�o");	
		
	}
	
	@Override
	public void close() {
		System.out.println("Fechando Conex�o");
		
	}
}
