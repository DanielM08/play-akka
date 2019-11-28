package akka.actors;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.bufferPackage.BufferRow;
import akka.bufferPackage.StorageInformation;
import akka.bufferPackage.StorageSearchResults;
import akka.utilities.CheckAbnormalExcedent;
import akka.utilities.Requests;
import akka.utilities.ResultMemory;

public class SearchActor extends AbstractActor{
	
	ArrayList<String> mapaHeader = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
		{
			add("Emissão Bilhete Aéreo");
			add("COMBUSTÍVEIS E LUBRIFICANTES.");
			add("TELEFONIA");
			add("SERVIÇO DE TÁXI, PEDÁGIO E ESTACIONAMENTO");
			add("SERVIÇOS POSTAIS");
			add("MANUTENÇÃO DE ESCRITÓRIO DE APOIO À ATIVIDADE PARLAMENTAR");
			add("FORNECIMENTO DE ALIMENTAÇÃO DO PARLAMENTAR");
			add("DIVULGAÇÃO DA ATIVIDADE PARLAMENTAR");
			add("HOSPEDAGEM ,EXCETO DO PARLAMENTAR NO DISTRITO FEDERAL.");
			add("LOCAÇÃO OU FRETAMENTO DE VEÍCULOS AUTOMOTORES");
			add("CONSULTORIAS, PESQUISAS E TRABALHOS TÉCNICOS.");
			add("PASSAGENS AÉREAS");
			add("PASSAGENS TERRESTRES, MARÍTIMAS OU FLUVIAIS");
			add("ASSINATURA DE PUBLICAÇÕES");
			add("SERVIÇO DE SEGURANÇA PRESTADO POR EMPRESA ESPECIALIZADA.");
			add("LOCAÇÃO OU FRETAMENTO DE AERONAVES");
			add("PARTICIPAÇÃO EM CURSO, PALESTRA OU EVENTO SIMILAR");
			add("LOCAÇÃO OU FRETAMENTO DE EMBARCAÇÕES");
		}
	};

	private StorageInformation dataBase = new StorageInformation();
	
	public static Props props() {
		return Props.create(SearchActor.class);
	}

	//private Map<String, Integer> finalReducedMap = new HashMap<String, Integer>();
	
	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(StorageInformation.class, dataB-> {
					System.out.println(dataB.getSize() + "SearchActor");
					dataBase = dataB;
					getSender().tell(new ResultMemory(), getSelf());										
				}).match(Requests.class, msg-> {
					getSender().tell(makeSearch(msg.getNome(), msg.getDataInicio(), msg.getDataFim()), getSelf());
				})	
			.build();
	}
	
	public StorageSearchResults makeSearch(String deptName, String date1, String date2) {

		//finalReducedMap.put("FIM", 1);
		
		StorageSearchResults storageDept = new StorageSearchResults(mapaHeader);
		SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
		
		Date firstDate;
		Date lastDate;
		try {
			firstDate = sdfo.parse(date1);
			lastDate = sdfo.parse(date2);
			
			List<BufferRow> storage = dataBase.getData();
			
			//System.out.println(storage.size());
			
			storage.parallelStream()
					.filter(row -> row.getDataTransacao() != null)
					.filter(row -> row.getDataTransacao().compareTo(lastDate) < 0 && row.getDataTransacao().compareTo(firstDate) > 0)
					.filter(row -> row.getNome().contentEquals(deptName) && CheckAbnormalExcedent.returnExcedent(row.getTipoGasto(), row.getValorLiquido()) > 0)				
					.forEach(row ->  storageDept.setValueAndLocation(row.getTipoGasto(), CheckAbnormalExcedent.returnExcedent(row.getTipoGasto(), row.getValorLiquido()), row.getLocalGasto(),  row.getValorLiquido()));
		
			//System.out.println(storageDept.printMapAverage());
			
			return storageDept;
			
		} catch (ParseException e) {			
			e.printStackTrace();
		}				
		return null;
	}
	
}
