package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteObjetct {

	public static void main(String[] args) {

		System.out.println("x");
		System.out.println(3);
		System.out.println(false);
		
		Object cc = new ContaCorrente(22, 33);
		Object cp = new ContaPoupanca(33, 22);
		Object cliente = new Cliente();
		
		System.out.println(cc);  //o espaço de memoria nomeado pode ser definido por toString
		System.out.println(cp);
		
		//println(cliente);
		

	}
	
	
	/**
	 * Sobrecarga
	 */
	
	static void println() {}	
	static void println(int a) {}
	static void println(boolean valor) {}

	static void println(Object classe) {} // todas as classes que não possuem extends possuem o extends object
}
