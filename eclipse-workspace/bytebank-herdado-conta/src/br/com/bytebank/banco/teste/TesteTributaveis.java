package br.com.bytebank.banco.teste;            //se ele estiver dentro de um diretorio precisa colocar aqui o diretorio

import br.com.bytebank.banco.modelo.*;     // diz de onde vem as classes instanciadas

public class TesteTributaveis {
	
	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(222, 333);	
		cc.deposita(100.0);
		
		SeguroDeVida seguro = new SeguroDeVida();
		
		CalculadorDeImposto calc = new CalculadorDeImposto();
	    calc.registra(cc);
	    calc.registra(seguro);
	    
	    System.out.println(calc.getTotalImposto());		
		
		
	}
	
	
}
