package akka.kafka;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import akka.cassandra.CassandraOp;
import akka.utilities.ReadCsvFile;

public class Manager {

	public static void runConsumer() {

		Consumer<Long, String> consumer = ConsumerCreator.createConsumer();

		int noMessageToFetch = 0;

		while (true) {

			final ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);

			if (consumerRecords.count() == 0) {

				noMessageToFetch++;

				System.out.println("NO MESSAGE TO FETCH: " + String.valueOf(noMessageToFetch));

				if (noMessageToFetch > IKafkaConstants.MAX_NO_MESSAGE_FOUND_COUNT)
					break;
				else
					continue;
			}

			consumerRecords.forEach(record -> {

				System.out.println("CHEGANDO NO CONSUMIDOR: " + record.value());


				// AQUI FICA O PROCESSAMENTO DAS MENSAGENS, OU SEJA, MANDAR PRO CASSANDRA				
				String[] parts = record.value().split(",");					
//				System.out.println(parts);


				// ARMAZENAR NO CASSANDRA
				try{
					String[] colunasInsert = { "id", "name", "expense_description", "provider", "date", "amount" };
					String[] valoresInsert = { parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]};

					CassandraOp.insertData("DeputyExpenses", colunasInsert, valoresInsert);
				}catch(Exception e) {				
					System.out.println("Foda-se");
				}

			});

			consumer.commitAsync();
		}
		consumer.close();
	}

	public static void runProducer() throws IOException {

		Producer<Long, String> producer = ProducerCreator.createProducer();

		ReadCsvFile archive = null;
		try {
			archive = new ReadCsvFile();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		String line;

		int id = 0;

		// enquanto tiver linhas
		while ((line = archive.getLine()) != "") {

			if (line == "skip")
				continue;
			if(id == 100)
				break;

			String message = String.valueOf(id) + "," + line;

			// par chave(nome do tópico)/valor a ser enviado pro kafka.
			final ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(IKafkaConstants.TOPIC_NAME,
					message);
			
			try {
				// envia dado pro servidor kafka
				RecordMetadata metadata = producer.send(record).get();
				System.out.println("Record sent with key " + message + " to partition " + metadata.partition()
						+ " with offset " + metadata.offset());

			} catch (ExecutionException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			} catch (InterruptedException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			}
			
			id += 1;
		}		
	}
}
