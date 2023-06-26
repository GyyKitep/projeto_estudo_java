package br.com.ecommerce;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;

import br.com.ecommerce.consumer.KafkaService;

public class LogService {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		var logService = new LogService();
		try (var service = new KafkaService(LogService.class.getSimpleName(), Pattern.compile("ECOMMERCE.*"),
				logService::parse,
				Map.of(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName()))) {
			service.run();
		}

	}

	private void parse(ConsumerRecord<String, Message<String>> record) {
		System.out.println("----------------------------------------");
		System.out.println("LOG: " + record.topic());
		System.out.println("Key " + record.key());
		System.out.println("Value " + record.value());
		System.out.println("Partition " + record.partition());
		System.out.println("Offset " + record.offset());

	}
}
