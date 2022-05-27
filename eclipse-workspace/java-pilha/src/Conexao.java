
public class Conexao implements AutoCloseable{
	
	//IllegalStateException e IllegalArgumentException são erros importantes para retornar 
	
	public Conexao() {
		System.out.println("Abrindo conexão");
		//throw new IllegalStateException("Deu erro na Conexão");	
	}
	
	public void leDados() {
		System.out.println("Recebendo Dados");
		throw new IllegalStateException("Deu erro na Conexão");	
		
	}
	
	@Override
	public void close() {
		System.out.println("Fechando Conexão");
		
	}
}
