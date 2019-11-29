package akka.actors;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import akka.actor.*;
import akka.bufferPackage.BufferRow;
import akka.bufferPackage.StorageSearchResults;
import akka.utilities.CheckAbnormalExcedent;
import akka.utilities.Requests;
import akka.utilities.ResultRequest;

import messages.*;

public class AggregateActor extends AbstractActor {

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
	
	String finalResult = "";
	private Requests requests;
	
	SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
	
	Date firstDate;
	Date lastDate;
	
	StorageSearchResults storageDept = new StorageSearchResults(mapaHeader);

	@Override
	public Receive createReceive() {
		return receiveBuilder().match(Requests.class, msg -> {
			requests = msg;
			firstDate = sdfo.parse(msg.getDataInicio());
			lastDate = sdfo.parse(msg.getDataFim());
						
			getSender().tell(new MsgQuery(99), getSelf());
		}).match(BufferRow.class, br -> {			
			makeSearch(br);			
		}).match(ResultRequest.class, s -> {
			getSender().tell(showSearchResults(), getSelf());
		}).build();
	}
	
	private void makeSearch(BufferRow br)
	{
		if(br.getDataTransacao() != null && br.getDataTransacao().compareTo(lastDate) < 0 && br.getDataTransacao().compareTo(firstDate) > 0)
		{			
			if(br.getNome().contentEquals(requests.getNome()) && CheckAbnormalExcedent.returnExcedent(br.getTipoGasto(), br.getValorLiquido()) > 0)
			{
				storageDept.setValueAndLocation(br.getTipoGasto(), CheckAbnormalExcedent.returnExcedent(br.getTipoGasto(), br.getValorLiquido()), br.getLocalGasto(),  br.getValorLiquido());
			}						
		}
	}
	
	private String showSearchResults() {
		String finalResult = storageDept.printMapAverage() + "\n";
		
		return finalResult;
	}
	
	public static Props props() {
		return Props.create(AggregateActor.class);
	}

}
