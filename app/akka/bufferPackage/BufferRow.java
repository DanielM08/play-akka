package akka.bufferPackage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BufferRow {

	private final String nome;
	private final String tipoGasto;
	private final String localGasto;
	private final Date dataTransacao;
	private final Double valorLiquido;

	public BufferRow(String nome, String tipoGasto, String localGasto,
			Date dataTransacao, Double valorLiquido) {
		this.nome = nome;
		this.tipoGasto = tipoGasto;
		this.localGasto = localGasto;
		this.dataTransacao = dataTransacao;
		this.valorLiquido = valorLiquido;
	}

	public String getNome() {
		return nome;
	}

	public String getTipoGasto() {
		return tipoGasto;
	}

	public String getLocalGasto() {
		return localGasto;
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}
	
	@Override
    public String toString() {
		SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
		
        return "Nome: " + this.nome + ", Descrição do Gasto: " + this.tipoGasto +
               ", Data: " + sdfo.format(dataTransacao) + ", Gasto: " + this.valorLiquido;
    }
}
