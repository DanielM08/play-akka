package akka.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadCsvFile {

	private File file;
	private Scanner scan;

	private final String path = "/home/danielmarx08/Ano-2017.csv";

	public ReadCsvFile() throws FileNotFoundException  {

		this.file = new File(path);
		this.scan= new Scanner(file);
		
		scan.nextLine();
	}

	public String getLine() {

		String toReturn = "";
		String row;
		
		if (scan.hasNextLine()) {
			row = scan.nextLine();
			
			String[] data = row.split(";");

			if (data[15].length() > 10) {

				toReturn += data[0] + "," + data[8] + "," + data[11] + "," + data[15] + "," + data[18];
				
				return toReturn;
			}
			else
			{
				return "skip";
			}
		}
		else
		{
			return toReturn;
		}
	}
}

