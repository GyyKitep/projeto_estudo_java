package br.com.ecommerce;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import br.com.database.LocalDatabase;
import br.com.ecommerce.consumer.ConsumerService;
import br.com.ecommerce.consumer.KafkaService;
import br.com.ecommerce.consumer.ServiceRunner;
import br.com.ecommerce.dispatcher.KafkaDispatcher;

public class FraudDetectorService implements ConsumerService<Order> {

	private final KafkaDispatcher<Order> orderDispatcher = new KafkaDispatcher<>();
	private final LocalDatabase database;

	private FraudDetectorService() throws SQLException {
		this.database = new LocalDatabase("frauds_database");

		database.creatIfNotExists("create table Orders (" + "uuid varchar(200) primary key," + "fraud boolean)");

	}

	public static void main(String[] args) throws IOException, SQLException, InterruptedException, ExecutionException {
		new ServiceRunner(FraudDetectorService::new).start(1);
	}

	public void parse(ConsumerRecord<String, Message<Order>> record)
			throws InterruptedException, ExecutionException, SQLException {
		System.out.println("----------------------------------------");
		System.out.println("Processing new order, checking for fraud");
		System.out.println("Key " + record.key());
		System.out.println("Value " + record.value());
		System.out.println("Partition " + record.partition());
		System.out.println("Offset " + record.offset());

		var message = record.value();
		var order = message.getPayload();

		if (wasProcessed(order)) {
			System.out.println("Order " + order.getOrderId() + " was already processed");
			return;
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// ignoring
			e.printStackTrace();
		}
		if (isFraud(order)) {
			database.update("insert into Oders (uuid, is_fraud) values (?,true)", order.getOrderId());

			// pretending that the fraud happens when the amount is >= 4500
			System.out.println("Order is a fraud!!!" + order);
			orderDispatcher.send("ECOMMERCE_ORDER_REJECTED", order.getEmail(),
					message.getId().continueWith(FraudDetectorService.class.getSimpleName()), order);
		} else {
			database.update("insert into Oders (uuid, is_fraud) values (?,false)", order.getOrderId());
			System.out.println("Approved: " + order);
			orderDispatcher.send("ECOMMERCE_ORDER_APPROVED", order.getEmail(),
					message.getId().continueWith(FraudDetectorService.class.getSimpleName()), order);
		}

		System.out.println("Order processed");

	}

	private boolean wasProcessed(Order order) throws SQLException {
		var results = database.query("select uuid from Orders where uuid = ? limit 1", order.getOrderId());
		return results.next();
	}

	private boolean isFraud(Order order) {
		return order.getAmount().compareTo(new BigDecimal(("4500"))) >= 0;
	}

	@Override
	public String getTopic() {
		return "ECOMMERCE_NEW_ORDER";
	}

	@Override
	public String getConsumerGroup() {
		return FraudDetectorService.class.getSimpleName();
	}

}
