package br.com.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import br.com.ecommerce.consumer.ConsumerService;
import br.com.ecommerce.consumer.ServiceRunner;

public class EmailService implements ConsumerService<Email>{

	public static void main(String[] args) {
		new ServiceRunner(EmailService::new).start(5);
	}


	public String getConsumerGroup() {
		return EmailService.class.getSimpleName();
	}
	
	
	
	public String getTopic() {
		return "ECOMMERCE_SEND_EMAIL";
	}

	public void parse(ConsumerRecord<String, Message<Email>> record) {

		System.out.println("----------------------------------------");
		System.out.println("Sending Email");
		System.out.println("Key " + record.key());
		System.out.println("Value " + record.value());
		System.out.println("Partition " + record.partition());
		System.out.println("Offset " + record.offset());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// ignoring
			e.printStackTrace();
		}

		System.out.println("Email send");
	}

}
