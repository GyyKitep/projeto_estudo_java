package br.com.ecommerce;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class FraudDetectorService {

	private final KafkaDispatcher<Order> orderDispatcher = new KafkaDispatcher<>();

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		var fraudService = new FraudDetectorService();
		try (var service = new KafkaService<>(FraudDetectorService.class.getSimpleName(), "ECOMMERCE_NEW_ORDER",
				fraudService::parse, Map.of())) {
			service.run();
		}
	}

	private void parse(ConsumerRecord<String, Message<Order>> record) throws InterruptedException, ExecutionException {
		System.out.println("----------------------------------------");
		System.out.println("Processing new order, checking for fraud");
		System.out.println("Key " + record.key());
		System.out.println("Value " + record.value());
		System.out.println("Partition " + record.partition());
		System.out.println("Offset " + record.offset());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// ignoring
			e.printStackTrace();
		}
		
		var message = record.value();
		
		var order = message.getPayload();
		if(isFraud(order)) {
			// pretending that the fraud happens when the amount is >= 4500
			System.out.println("Order is a fraud!!!" + order);	
			orderDispatcher.send("ECOMMERCE_ORDER_REJECTED", order.getEmail(), message.getId().continueWith(FraudDetectorService.class.getSimpleName()), order);		
		} else {
			System.out.println("Approved: " + order);
			orderDispatcher.send("ECOMMERCE_ORDER_APPROVED", order.getEmail(), message.getId().continueWith(FraudDetectorService.class.getSimpleName()), order);	
		}
		

		System.out.println("Order processed");

	}

	private boolean isFraud(Order order) {
		return order.getAmount().compareTo(new BigDecimal(("4500"))) >= 0;
	}

}
