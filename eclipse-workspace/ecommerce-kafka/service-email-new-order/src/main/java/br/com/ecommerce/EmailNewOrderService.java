package br.com.ecommerce;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import br.com.ecommerce.consumer.ConsumerService;
import br.com.ecommerce.consumer.KafkaService;
import br.com.ecommerce.consumer.ServiceRunner;
import br.com.ecommerce.dispatcher.KafkaDispatcher;

public class EmailNewOrderService implements ConsumerService<Order>{

	private final KafkaDispatcher<Email> emailDispatcher = new KafkaDispatcher<>();

	public static void main(String[] args) {
		new ServiceRunner(EmailNewOrderService::new).start(1);
	}

	public void parse(ConsumerRecord<String, Message<Order>> record) throws InterruptedException, ExecutionException {
		System.out.println("----------------------------------------");
		System.out.println("Processing new order, preparing email");
		System.out.println("Value " + record.value());

		var mensagem = record.value();
		var payload = mensagem.getPayload();
		var id = mensagem.getId().continueWith(EmailNewOrderService.class.getSimpleName());

		var emailCode = new Email("email_subject", "email_body");
		emailDispatcher.send("ECOMMERCE_SEND_EMAIL", payload.getEmail(), id, emailCode);

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
		// TODO Auto-generated method stub
		return EmailNewOrderService.class.getSimpleName();
	}

}
