package akka.utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadCsvFile {

	private FileInputStream fis;
	private BufferedReader csvReader;

	private final String path = "/home/danielmarx08/Ano-2017.csv";

	public ReadCsvFile() throws IOException {

		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		csvReader = new BufferedReader(new InputStreamReader(fis));

		String[] firstRow = csvReader.readLine().split(";");
		firstRow[0] = "...";
	}

	public String getLine() {

		String toReturn = "";
		String row;
		try {
			row = csvReader.readLine();

			if(row == null)
			{				
				return "FIM";
			}
			String[] data = row.split(";");

			if (data[15].length() > 10) {

				toReturn += data[0] + ";" + data[8] + ";" + data[11] + ";" + data[15] + ";" + data[18];
			}
			return toReturn;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "FIM";
	}
}
