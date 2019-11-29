package akka.cassandra;

import akka.actor.*;
import akka.bufferPackage.BufferRow;

import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class CassandraActor extends AbstractActor {

	//private Cluster cluster;
	//private Session session;

	static public Props props() {
		return Props.create(CassandraActor.class);
	}
	
	SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
	
	public CassandraActor() {
		CassandraOp.startConnection();		
		CassandraOp.startSession("expenses");
		
		Metadata metadata = CassandraOp.getMetadata();		
		System.out.printf("@@@@@@@Connected to cluster: %s\n", metadata.getClusterName());
	}
	
	public BufferRow queryUser(Integer i) {
		ResultSet results = CassandraOp.queryData("DeputyExpenses", i);
				
		BufferRow br = null;
		
		for (Iterator<Row> iterator = results.iterator(); iterator.hasNext();) {
			Row row = iterator.next();				

			double amount = Double.parseDouble(row.getString("amount"));			
			Date date = null;
			
			try {
				String dateToConvert = row.getString("date").substring(0, 10);
				Date d1 = sdfo.parse(dateToConvert);
				date = d1;
			} catch (ParseException e) {
				// Ignore Error
			}
			
			br = new BufferRow(row.getString("name"), row.getString("expense_description"), 
					row.getString("provider"), date, amount);
			break;
		}
		return br;
	}
	
	@Override
	public Receive createReceive() {
		return receiveBuilder().match(Integer.class, s -> {
			sender().tell(queryUser(s), self());
		}).build();
	}
}