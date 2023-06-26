package br.com.ecommerce;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import br.com.ecommerce.dispatcher.KafkaDispatcher;

public class NewOrderMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {

		try (var orderDispatcher = new KafkaDispatcher<Order>()) {
			var orderId = UUID.randomUUID().toString();
			var amount = new BigDecimal(Math.random() * 5000 + 1);
			var email = Math.random() + "@email.com";

			var order = new Order(orderId, amount, email);

			var id = new CorrelationId(NewOrderMain.class.getSimpleName());

			orderDispatcher.send("ECOMMERCE_NEW_ORDER", email, id, order);

		}
		;

	}

}
