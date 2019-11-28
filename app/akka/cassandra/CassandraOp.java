package akka.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class CassandraOp {
	
	private static Cluster cluster;
    private static Session session;
 
    public static Cluster connect(String node) {
        return Cluster
        		.builder()
        		.addContactPoint(node)
        		.build();  
    }
    
    public static void startConnection() {
    	try {
        	cluster = connect("10.128.0.4");	        	
    	} catch (Exception e) {
    		System.out.println("CONEXÃO INCOMPLETA");
		}
    }
    
    public static void startSession(String KeySpaceName) {
    	try {
    		session = cluster.connect(KeySpaceName);    
    		System.out.println("conectadoo -----");
    	} catch (Exception e) {    		
		}
    }
    
    public static Metadata getMetadata() {
    	return cluster.getMetadata();
    }
           
    public static void createKeyspace(String keyspaceName) {    	
    	//session = cluster.connect();
    	System.out.println("conectadoo -----");
    	
    	session.execute("CREATE KEYSPACE "+keyspaceName+ " WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1}");    	
	}
    
    public static void deleteKeyspace( String keyspaceName ) {
    	session.execute("DROP KEYSPACE "+keyspaceName);
    }
    
    public static void closeConnection() {
    	session.close();
    	cluster.close();
    }
    
    public static void createTable(String tableName, String[] columnsName, String[] dataType, int primaryKey) {
    	String cquery = "";
    	for( int i=0; i<columnsName.length; i++ ){
    		cquery += columnsName[i] +" " +dataType[i] +",";
    	}
    	
    	cquery += "PRIMARY KEY (" + columnsName[primaryKey] +")";
    	
    	session.execute("CREATE TABLE "+tableName+ " ("+cquery+")");    	
    }
    
    public static void dropTable(String table){
    	session.execute("DROP TABLE "+table);
    }
        
    public static void insertData(String table, String[] columns, String[] valuesToInsert){
    	
    	String fields = "";
    	String values = "";
    	
    	fields += columns[0]+",";
    	values += valuesToInsert[0]+",";
    	
    	for( int i=1; i<columns.length; i++ ) {
    		fields += columns[i]+",";    		
    		values += "'"+valuesToInsert[i]+"',";    		
    	}
    	
    	fields = fields.substring(0, fields.length()-1);
    	values = values.substring(0, values.length()-1);
    	
    	session.execute("INSERT INTO "+table+" ("+fields+") VALUES ("+values+")");    	    
    } 
    
    public static ResultSet queryData(String table, Integer id)
    {
    	ResultSet results = session.execute("SELECT * FROM "+ table +" WHERE id = " + Integer.toString(id));
    	
    	return results;
    }
}
