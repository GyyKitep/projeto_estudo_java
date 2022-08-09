package br.com.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexao();
				
			                                        
		Statement stm = con.createStatement();
		boolean resultado = stm.execute("DELETE FROM PRODUTO WHERE ID > 1");	//volta true se form lista	
		Integer linhasModificadas = stm.getUpdateCount();	
		
		System.out.println("Quantidade de linhas que goram modificadas: " + linhasModificadas);
		
		con.close();
	}
	
}
