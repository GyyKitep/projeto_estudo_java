package br.com.ecommerce;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class FraudDetectorService {

	public static void main(String[] args) throws IOException {
		var fraudService = new FraudDetectorService();
		try (var service = new KafkaService(FraudDetectorService.class.getSimpleName(), "ECOMMERCE_NEW_ORDER", fraudService::parse)){
			service.run();
		}
	}		
		
	private void parse(ConsumerRecord<String, String> record) {
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

		System.out.println("Order processed");

	}

}
