package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayListEquals {

	public static void main(String[] args) {
		
		 //o <> faz com que a lista aceite apenas objetos do tipo Conta
		ArrayList<Conta> lista = new ArrayList<Conta>();
		
		Conta cc = new ContaCorrente(22, 11);		
		lista.add(cc);
		
		Conta cc2 = new ContaCorrente(22, 22);		
		lista.add(cc2);

		Conta cc3 = new ContaCorrente(22, 22);
		boolean existe = lista.contains(cc3);  //contains chama o metodo equal e como ele usa o equal do objeto conta ele usa a sobrescrita do metodo    
		
		System.out.println("Já existe?" + existe);
	
		for(Conta conta : lista) {
			
			System.out.println(conta);
		}
	}

}
