package br.com.ecommerce;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {

		try (var dispatcher = new KafkaDispatcher()){
			
			var key = UUID.randomUUID().toString();
			var value = key + ",0123,129837129";
			
			dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);
			
			
			var email = "Thank you for your order! We are processing your order!";
			dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);
		};
		
		
	}


}
