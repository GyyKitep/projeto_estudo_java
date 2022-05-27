
public class TesteConexao {
	
	public static void main(String[] args) {
		
		//---------------desde o java 1.7------------------------
		try(Conexao conexao = new Conexao()){ // para fazer isso a classe é obrigada a ter um contrato
			conexao.leDados();			      // desse modo com o autoclose ele chama o close como finally sem declarar
		} catch (IllegalStateException ex) {
			System.out.println(ex.getMessage());
			
		}
		
		//------------------Codigo legado----------------------
		
//		Conexao con = null;
//		
//		try {                             // o try é obrigado a vir com catch ou finally, pelo menos 1 dos 2
//			con = new Conexao();
//			con.leDados();
//			//con.fecha();			
//		} catch (IllegalStateException ex) {
//			System.out.println(ex.getMessage());
//			//con.fecha();
//			
//		} finally {                  // sempre será executado, com ou sem erro
//		
//			if(con != null) {
//				con.close();
//			}
//		}
	}

}
