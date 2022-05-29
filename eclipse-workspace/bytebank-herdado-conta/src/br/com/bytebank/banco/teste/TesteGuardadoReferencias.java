package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.GuardadoDeContas;
import br.com.bytebank.banco.modelo.GuardadorDeReferencias;

public class TesteGuardadoReferencias {

	public static void main(String[] args) {
		
		GuardadorDeReferencias guardador = new GuardadorDeReferencias();
		
		Conta cc = new ContaCorrente(22, 11);		
		guardador.adiciona(cc);
		
		Conta cc2 = new ContaCorrente(22, 22);		
		guardador.adiciona(cc2);
		
		int tamanho = guardador.getQuantidadeDeElementos();
		
		System.out.println(tamanho);
		
		Conta ref = (Conta) guardador.getReferencia(1);  //cast faz a tranferencia generica virar uma especifica
		System.out.println(ref.getNumero());

	}
}
