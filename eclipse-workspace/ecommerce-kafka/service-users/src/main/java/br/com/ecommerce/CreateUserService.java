package br.com.ecommerce;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import br.com.database.LocalDatabase;
import br.com.ecommerce.consumer.ConsumerService;
import br.com.ecommerce.consumer.ServiceRunner;

public class CreateUserService implements ConsumerService<Order> {

	private final LocalDatabase database;

	private CreateUserService() throws SQLException {
		this.database = new LocalDatabase("users_database");

		database.creatIfNotExists("create table Users (" + "uuid varchar(200) primary key," + "email varchar(200))");

	}

	public static void main(String[] args) throws IOException, SQLException, InterruptedException, ExecutionException {
		new ServiceRunner(CreateUserService::new).start(1);
	}

	public void parse(ConsumerRecord<String, Message<Order>> record) throws SQLException {
		System.out.println("----------------------------------------");
		System.out.println("Processing new order, checking for new User");

		var message = record.value();

		System.out.println("Value " + message.getPayload());
		var order = message.getPayload();

		if (isNewUser(order.getEmail())) {
			insertNewUser(order.getEmail());
		}

	}

	private void insertNewUser(String email) throws SQLException {
		String uuid = UUID.randomUUID().toString();
		database.update("insert into User(uuid, email) " + "values (?,?)", uuid, email);

		System.out.println("Usu�rio " + uuid + " e " + email + " adicionado");

	}

	private boolean isNewUser(String email) throws SQLException {
		var results = database.query("select uuid from Users " + "where email = ? limit 1", email);

		return !results.next();
	}

	@Override
	public String getTopic() {
		return "ECOMMERCE_NEW_ORDER";
	}

	@Override
	public String getConsumerGroup() {
		return CreateUserService.class.getSimpleName();
	}
}
