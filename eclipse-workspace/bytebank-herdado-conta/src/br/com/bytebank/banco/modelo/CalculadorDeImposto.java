package br.com.bytebank.banco.modelo;            //se ele estiver dentro de um diretorio precisa colocar aqui o diretorio


// modelo.CAlculadorDeImposto => Full qualified name
public class CalculadorDeImposto {
	
	private double totalImposto;
	
	
	public void registra(Tributavel t) {
		double valor = t.getValorImposto();
		this.totalImposto += valor;
		
	}
	
	public double getTotalImposto() {
		return totalImposto;
	}

}
