package br.com.bytebank.banco.teste;            //se ele estiver dentro de um diretorio precisa colocar aqui o diretorio

import br.com.bytebank.banco.modelo.*;     // diz de onde vem as classes instanciadas

public class TesteSaca {

	public static void main(String[] args) {
		Conta conta = new ContaCorrente(123, 321);
		
		conta.deposita(200.0);
		
		try {
			conta.saca(210.0);
		} catch(SaldoInsuficienteExcepction ex) {
			System.out.println("Ex: " + ex.getMessage());
		}
		
		System.out.println(conta.getSaldo());

	}

}
