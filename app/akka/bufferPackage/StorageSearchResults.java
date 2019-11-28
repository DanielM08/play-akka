package akka.bufferPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StorageSearchResults {
	private Map<String, Double> aboveAverage;
	private Map<String, Map<String, Pair<Integer, Double>>> principalLocations;
	private int numRegisters;
	
	public StorageSearchResults(ArrayList<String> keysHash) {
		this.aboveAverage = new HashMap<String, Double>();
		this.principalLocations = new HashMap<String, Map<String, Pair<Integer, Double>>>();
		for (int i = 0; i < keysHash.size(); i++) {
			aboveAverage.put(keysHash.get(i), 0.0);
			principalLocations.put(keysHash.get(i), null);
		} 
		numRegisters = 0;		
	}
	
	public Integer setNumRegisters()
	{	
		return numRegisters++;
	}
	
	public void setValueAndLocation(String key, double excedent, String local, Double value)
	{
		//System.out.println(key);
		setValue(key, excedent);
		setLocationOccurrence(key, local, value);
	}
	
	public void setValue(String key, double excedent) {
		numRegisters++;
		double atualValue = this.aboveAverage.get(key);
		aboveAverage.put(key, atualValue + excedent);			
	}

	public void setLocationOccurrence(String key, String local, Double value) {

		Map<String, Pair<Integer, Double>> map = principalLocations.get(key);

		if (map == null) {
			map = new HashMap<String, Pair<Integer, Double>>();
		}
		if (map.get(local) == null) {
			Pair<Integer, Double> pair = new Pair<Integer, Double>(1, value);
			map.put(local, pair);
			pair = null;
		} else {
			Pair<Integer, Double> pair = map.get(local);

			int actualQuantity = pair.getFirst();
			double actualValue = pair.getSecond();
			pair = new Pair<Integer, Double>(actualQuantity + 1, actualValue + value);

			map.put(local, pair);
			pair = null;
		}
		principalLocations.put(key, map);
		map = null;	
	}

	public String printMapAverage() {
		
		String toReturn = "";
		
		if (numRegisters == 0) {
			toReturn += "Não foram encontrados quaisquer registros no período informado";
		} else {
			toReturn += "Soma de gastos excedentes (acima da média)\n";
			for (String name : aboveAverage.keySet()) {				
				Double value = aboveAverage.get(name);
				
				toReturn += "Tipo gasto: " + name + " - Valor excedente: "+ Double.toString(value) + "\n";				
			}
		}
		
		return toReturn;
	}

	public String printMapLocations(String key) {
		
		String toReturn = "";
		
		try {
			toReturn += "Principais localizações dos gastos de " + key + "/Nº de ocorrências / Média de gasto no local ";
			Map<String, Pair<Integer, Double>> map = principalLocations.get(key);

			for (String name : map.keySet()) {
				Integer value = map.get(name).getFirst();
				Double amount = map.get(name).getSecond() / value;
				toReturn += "Local: " + name + " - Nº ocorrências: "+ Double.toString(value) + "- Média Gastos: " + Double.toString(amount) + "\n";
				// System.out.println(name + " " + value.toString() + " " + amount.toString());
			}
			
			return toReturn;
		} catch (Exception e) {
			toReturn += "Registros não encontrados";
			return toReturn;
		}
	}
}
