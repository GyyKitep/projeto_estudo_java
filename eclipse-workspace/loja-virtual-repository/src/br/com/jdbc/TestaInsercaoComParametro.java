package br.com.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		try(Connection connection = factory.recuperarConexao()){				
			connection.setAutoCommit(false); // comando que faz vc ter que aprovar a acao que foi mandada para o banco

			try {
				PreparedStatement stm = connection.prepareStatement(
						"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

				adicionarVariavel("Smart TV", "45 polegadas", stm);
				adicionarVariavel("Radio", "Radio de bateria", stm);

				connection.commit(); // aprova as acoes

				stm.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}

	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();
		
		if(nome.equals("Radio")) {
			throw new RuntimeException("Nao foi possivel adicionar o produto");
		}

		try(ResultSet rst = stm.getGeneratedKeys()){
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}			
		}

	}

}
