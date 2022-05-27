package br.com.bytebank.banco.teste;            //se ele estiver dentro de um diretorio precisa colocar aqui o diretorio

import br.com.bytebank.banco.especial.ContaEspecial;
import br.com.bytebank.banco.modelo.ContaCorrente;                       
import br.com.bytebank.banco.modelo.ContaPoupanca;                      // crtl + shoft + o
import br.com.bytebank.banco.modelo.SaldoInsuficienteExcepction;

//import br.com.bytebank.banco.modelo.ContaCorrente;
//import br.com.bytebank.banco.modelo.ContaPoupanca;
//import br.com.bytebank.banco.modelo.SaldoInsuficienteExcepction;

//import br.com.bytebank.banco.modelo.*;     // diz de onde vem as classes instanciadas

//o java.lang é importato automaticamente, mas ele pode ser importato se quiser, sem ele não da para fazer programas

public class TesteConta {
	
	//java.lang.String
	public static void main(String[] args) throws SaldoInsuficienteExcepction{
				
		// full qualified name fqn		
		ContaCorrente cc = new ContaCorrente(111, 111);
		cc.deposita(100.0);
		
		ContaPoupanca cp = new ContaPoupanca(222, 222);
		cp.deposita(200.0);	
		
		cc.transfere(10.0, cp);
		
		System.out.println("CC: " + cc.getSaldo());
		System.out.println("CP: " + cp.getSaldo());
	}
}
