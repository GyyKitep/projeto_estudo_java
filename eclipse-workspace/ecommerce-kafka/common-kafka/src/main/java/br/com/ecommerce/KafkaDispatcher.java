package br.com.ecommerce;

import java.io.Closeable;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaDispatcher<T> implements Closeable{

	private final KafkaProducer<String, Message<T>> producer;

	public KafkaDispatcher() {
		this.producer = new KafkaProducer<>(properties());
	}

	private static Properties properties() {

		var properties = new Properties();

		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GsonSerializer.class.getName());
		properties.setProperty(ProducerConfig.ACKS_CONFIG, "all");

		return properties;
	}
	
	public void send(String topic, String key, CorrelationId id,T payload) throws InterruptedException, ExecutionException {
		var future = sendAsync(topic, key, id, payload);
		future.get();

	}

	public Future<RecordMetadata> sendAsync(String topic, String key, CorrelationId id, T payload) {
		var value = new Message<>(id, payload);
		var record = new ProducerRecord<>(topic, key, value);

		Callback callback = (data, ex) -> { // enviador de pedido
			if (ex != null) {
				ex.printStackTrace();
				return;
			}
			System.out.println("sucesso enviando " + data.topic() + " ::: partition " + data.partition() + " / offset "
					+ data.offset() + " / timestamp " + data.timestamp());

		};

		return producer.send(record, callback);
	}

	@Override
	public void close() throws IOException {
		producer.close();
		
	}
}
