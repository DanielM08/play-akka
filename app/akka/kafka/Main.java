package akka.kafka;

import java.io.IOException;
import java.util.Iterator;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import akka.cassandra.CassandraOp;

public class Main {

	public static void main() throws IOException {

		/* KAFKA */
		
		CassandraOp.startConnection();
		CassandraOp.startSession("expenses");
		
		Manager.runProducer();
		Manager.runConsumer();
		
		
		CassandraOp.closeConnection();
		
		
		/*ArchiveRead archive = null;
		try {
			archive = new ArchiveRead();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		String line="";
		
		while( (line = archive.getLine()) != "" ) {			
		
			
			String message = archive.process(line);
			System.out.println(message);
			
		}*/
		
		//CASSANDRA
	
		/*	  
		long tempoInicial = System.currentTimeMillis();
				
		CassandraOp.startConnection();
		
		System.out.println("CONEXAO INICIADA");
		
		CassandraOp.startSession("expenses");
		CassandraOp.createKeyspace("expenses");

		//CassandraOp.dropTable("DeputyExpenses");
		
		String[] columnsInsert = { "id", "name", "expense_description", "provider", "date", "amount" };
		String[] typeData = {"int", "text", "text", "text", "text", "text"};

		CassandraOp.createTable("DeputyExpenses", columnsInsert, typeData, 0);
		
		System.out.println("TABELA CRIADA COM SUCESSO");
		
		String[] colsToInsert = { "id", "name", "expense_description", "provider", "date", "amount" };
		String[] valuesToInsert = {"0", "name", "expense_description", "provider", "date", "amount"};
		
		CassandraOp.insertData("DeputyExpenses", colsToInsert, valuesToInsert);
		
		System.out.println("DADO INSERIDO COM SUCESSO");
		
		ResultSet query = CassandraOp.queryData("DeputyExpenses", 0);
		
		for (Iterator<Row> iterator = query.iterator(); iterator.hasNext();) {
			Row row = iterator.next();
			System.out.println(row.getString("name") + " " + row.getString("expense_description") + "  " + row.getString("amount"));
		}
	
		CassandraOp.closeConnection();
		
		System.out.println("CONEXAO ENCERRADA");
				
		System.out.println((System.currentTimeMillis()-tempoInicial)/1000 +" seg");
		*/		
	}
}
