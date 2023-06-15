package br.com.ecommerce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class CreateUserService {
	
	private final Connection connection;


	public CreateUserService() throws SQLException {
		String url = "jdbc:sqlite:target/users_database.db";
		this.connection = DriverManager.getConnection(url);
		
		try {
			connection.createStatement().execute("create table Users (" +
					"uuid varchar(200) primary key," +
					"email varchar(200))");
			
		} catch (Exception e) {
			// be careful, the sql could be wrong
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws IOException, SQLException, InterruptedException, ExecutionException {
		var createUserService = new CreateUserService();
		try (var service = new KafkaService<>(CreateUserService.class.getSimpleName(), "ECOMMERCE_NEW_ORDER",
				createUserService::parse,
				Map.of())) {
			service.run();
		}
	}
	

	private void parse(ConsumerRecord<String, Message<Order>> record) throws  SQLException {
		System.out.println("----------------------------------------");
		System.out.println("Processing new order, checking for new User");
		
		var message = record.value();
		
		System.out.println("Value " + message.getPayload());
		var order = message.getPayload();
		
		if(isNewUser(order.getEmail())){
			insertNewUser(order.getEmail());
		}

	}

	private void insertNewUser(String email) throws SQLException {
		var insert = connection.prepareStatement("insert into User(uuid, email) " +
				"values (?,?)");
		insert.setString(1, UUID.randomUUID().toString());
		insert.setString(2, email);
		insert.execute();
		System.out.println("Usuário uuid e " + email + " adicionado");
		
	}

	private boolean isNewUser(String email) throws SQLException {
		var exists = connection.prepareStatement("select uuid from Users " +
				"where email = ? limit 1");
		exists.setString(1, email);
		var result = exists.executeQuery();
		return !result.next();
	}
}
