package akka.utilities;

public class CheckAbnormalExcedent {
	
	public CheckAbnormalExcedent()
	{}

	public synchronized static double returnExcedent(String txtDescription, double amount)
	{
		if(txtDescription.equals("Emissão Bilhete Aéreo"))
		{
			if(amount > 0)		
				//return amount - 488;				
				return amount;
			else
				return 0;			
		}
		
		if(txtDescription.equals("COMBUSTÍVEIS E LUBRIFICANTES."))
		{			
			if(amount > 265)						
				return amount - 265;					
			else
				return 0;			
		}
				
		if(txtDescription.equals("TELEFONIA"))
		{
			if(amount > 185)		
				return amount - 185;		
			else
				return 0;
		}
		
		if(txtDescription.equals("SERVIÇO DE TÁXI, PEDÁGIO E ESTACIONAMENTO"))
		{
			if(amount > 35)		
				return amount - 35;		
			else
				return 0;
		}
		
		if(txtDescription.equals("SERVIÇOS POSTAIS"))
		{
			if(amount > 141)		
				return amount - 141;		
			else
				return 0;
		}
		
		if(txtDescription.equals("MANUTENÇÃO DE ESCRITÓRIO DE APOIO À ATIVIDADE PARLAMENTAR"))
		{
			if(amount > 1022)		
				return amount - 1022;		
			else
				return 0;
		}
		
		if(txtDescription.equals("FORNECIMENTO DE ALIMENTAÇÃO DO PARLAMENTAR"))
		{
			if(amount > 66)		
				return amount - 66;		
			else
				return 0;
		}
		
		if(txtDescription.equals("DIVULGAÇÃO DA ATIVIDADE PARLAMENTAR"))
		{
			if(amount > 4403)		
				return amount - 4403;		
			else
				return 0;
		}
		
		if(txtDescription.equals("HOSPEDAGEM ,EXCETO DO PARLAMENTAR NO DISTRITO FEDERAL."))
		{
			if(amount > 279)		
				return amount - 279;		
			else
				return 0;
		}
		
		if(txtDescription.equals("LOCAÇÃO OU FRETAMENTO DE VEÍCULOS AUTOMOTORES"))
		{
			if(amount > 0)
				return amount;
				//return amount - 4351;		
			else
				return 0;
		}
		
		if(txtDescription.equals("CONSULTORIAS, PESQUISAS E TRABALHOS TÉCNICOS."))
		{
			if(amount > 7500)		
				return amount - 7500;		
			else
				return 0;
		}
		
		if(txtDescription.equals("PASSAGENS AÉREAS"))
		{
			if(amount > 1133)		
				return amount - 1133;		
			else
				return 0;
		}
		
		if(txtDescription.equals("PASSAGENS TERRESTRES, MARÍTIMAS OU FLUVIAIS"))
		{
			if(amount > 87)		
				return amount - 87;		
			else
				return 0;
		}
		
		if(txtDescription.equals("ASSINATURA DE PUBLICAÇÕES"))
		{
			if(amount > 400)		
				return amount - 400;		
			else
				return 0;			
		}
		
		if(txtDescription.equals("SERVIÇO DE SEGURANÇA PRESTADO POR EMPRESA ESPECIALIZADA."))
		{
			if(amount > 1765)		
				return amount - 1765;		
			else
				return 0;
		}
		
		if(txtDescription.equals("LOCAÇÃO OU FRETAMENTO DE AERONAVES"))
		{
			if(amount > 10035)		
				return amount - 10035;		
			else
				return 0;
		}
		
		if(txtDescription.equals("PARTICIPAÇÃO EM CURSO, PALESTRA OU EVENTO SIMILAR"))
		{
			if(amount > 4414)		
				return amount - 4414;		
			else
				return 0;
		}
		
		if(txtDescription.equals("LOCAÇÃO OU FRETAMENTO DE EMBARCAÇÕES"))
		{
			if(amount > 4088)		
				return amount - 4088;		
			else
				return 0;
		}
			
		return -1;
	}
}
