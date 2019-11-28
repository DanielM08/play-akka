package akka.cassandra;

import akka.actor.*;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import java.util.Iterator;

public class CassandraActor extends AbstractActor {

	//private Cluster cluster;
	//private Session session;

	static public Props props() {
		return Props.create(CassandraActor.class);
	}
	
	public CassandraActor() {
		//cluster = Cluster.builder().addContactPoint("127.0.0.1").withCredentials("cassandra", "cassandra").build();
		Metadata metadata = CassandraOp.getMetadata();
		//session = cluster.connect("example_play");
		System.out.printf("@@@@@@@Connected to cluster: %s\n", metadata.getClusterName());
	}

	public String queryUser(Integer i) {
		ResultSet results = CassandraOp.queryData("DeputyExpenses", i);
		String line = "";
		for (Iterator<Row> iterator = results.iterator(); iterator.hasNext();) {
			Row row = iterator.next();
			line += row.getString("nome") + "\n";
		}
		return line;
	}
	
	@Override
	public Receive createReceive() {
		return receiveBuilder().match(Integer.class, s -> {
			sender().tell(queryUser(s), self());
		}).build();
	}
}