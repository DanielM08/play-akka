package akka.utilities;

public class Requests {

	String nome;
	String dataInicio;
	String dataFim;
	
	public Requests(String nome, String dataInicio, String dataFim) {
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
	
	public String getNome() {
		return nome;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}
}
