package akka.actors;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.bufferPackage.BufferRow;
import akka.bufferPackage.StorageInformation;
import akka.utilities.ResultRequest;

public class MemoryActor extends AbstractActor {

	private StorageInformation dataBase = new StorageInformation();
	private FileInputStream fis;
	private BufferedReader csvReader;

	public static Props props() {
		return Props.create(MemoryActor.class);
	}

	//private Map<String, Integer> finalReducedMap = new HashMap<String, Integer>();
	
	private final String path = "/home/danielmarx/Documents/TI/8ºSemestre/Concorrente/ProjetoDisciplina/Ano-2017.csv";
	
	@Override
	public Receive createReceive() {
		return receiveBuilder().match(ResultRequest.class, msg -> {
			getSender().tell(uploadDatabase(path), getSelf());
		})
		.build();
	}

	private StorageInformation uploadDatabase(String path) {

		try {
			fis = new FileInputStream(path);
			csvReader = new BufferedReader(new InputStreamReader(fis));

			SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");

			String[] firstRow;
			firstRow = csvReader.readLine().split(";");
			firstRow[0] = "...";

			String row = null;
			BufferRow br = null;

			while ((row = csvReader.readLine()) != null) {

				String[] data = row.split(";");

				row = null;
				Date date = null;

				if (data[15].length() > 10) {
					try {
						String dateToConvert = data[15].substring(0, 10);

						Date d1 = sdfo.parse(dateToConvert);
						date = d1;
					} catch (ParseException e) {
						// Ignore Error
					}
				}
				double amount = Double.parseDouble(data[18]);

				//System.out.println(data[0]);
				
				br = new BufferRow(data[0], data[8], data[11], date, amount);

				dataBase.setRow(br);
			}
			
			//finalReducedMap.put("FIM", 1);
			
			//System.out.println("Chegou aqui ;-;");
			
			return dataBase;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}				
		return dataBase;
	}
}
