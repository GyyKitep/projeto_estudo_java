package br.com.bytebank.banco.modelo;            //se ele estiver dentro de um diretorio precisa colocar aqui o diretorio


public class SaldoInsuficienteExcepction extends Exception{
	
	public SaldoInsuficienteExcepction(String msg) {
		super(msg);
		
	}

}
