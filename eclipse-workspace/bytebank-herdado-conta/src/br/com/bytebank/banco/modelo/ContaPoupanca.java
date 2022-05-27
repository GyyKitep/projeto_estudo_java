package br.com.bytebank.banco.modelo;            //se ele estiver dentro de um diretorio precisa colocar aqui o diretorio


public class ContaPoupanca extends Conta {
	
	public ContaPoupanca(int agencia, int numero) {
		super(agencia, numero);
		
	}
	
	@Override
	public void deposita(double valor) {
		super.saldo = this.saldo + valor;	
	}
	
	@Override
	public String toString() {
		return "ContaPoupanca, " + super.toString();
	}
	

}
