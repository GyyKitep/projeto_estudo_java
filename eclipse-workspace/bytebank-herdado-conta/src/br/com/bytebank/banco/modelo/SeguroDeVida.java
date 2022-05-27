package br.com.bytebank.banco.modelo;            //se ele estiver dentro de um diretorio precisa colocar aqui o diretorio


public class SeguroDeVida implements Tributavel {

	@Override
	public double getValorImposto() {
		return 42;
	}

}
