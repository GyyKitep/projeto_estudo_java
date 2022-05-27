package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*;

public class TestArrayReferencias {

	public static void main(String[] args) {
		
		Object[] contas = new Object[5]; // array de referencias
		
		System.out.println(contas.length);
		
		Cliente cliente = new Cliente();
		
		contas[2] = cliente;
		
		ContaCorrente cc1 = new ContaCorrente(22, 11);
		
		contas[0] = cc1;
		
		ContaPoupanca cc2 = new ContaPoupanca(22, 22);
		
		contas[1] = cc2;
		
		//Conta ref = contas[0];  --> ele obriga a usar conta n�o deixa usar ContaCorrente, msm vc sabendo que vai vir uma conta corrend
		ContaCorrente ref = (ContaCorrente) contas[0]; //type cast for�a o codigo a aceitar a especifica��o é obrigado a chamar uma conta corrente
		System.out.println(cc1.getNumero());
		//System.out.println(contas[0].getNumero());  para funcionar tem que fazer uma referencia de tipo cast  
		System.out.println(ref.getNumero());		
	}

}
