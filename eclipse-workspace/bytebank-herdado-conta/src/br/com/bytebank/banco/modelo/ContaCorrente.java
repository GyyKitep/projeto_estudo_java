package br.com.bytebank.banco.modelo;            //se ele estiver dentro de um diretorio precisa colocar aqui o diretorio


public class ContaCorrente extends Conta implements Tributavel{ // herença não erda os contrutores

	public ContaCorrente(int agencia, int numero) {    // se tirar o public apenas a esta classe pode usar
		super(agencia, numero); //chamada do construtor da classe mãe 
		
	}
	
	@Override
	public void saca(double valor) throws SaldoInsuficienteExcepction{  // para reescrever o metodo toda a estrutura tem que ser igual, mas dentro dela pode ser diferente 
		double valorASacar = valor + 0.2;
	    super.saca(valorASacar);
	}

	@Override
	public void deposita(double valor) {
		super.saldo = this.saldo + valor;	
	}
	
	@Override
	public double getValorImposto() {
		return super.saldo * 0.01;
	}
	
	@Override
	public String toString() {
		return "ContaCorrente, " + super.toString();
	}
	
}
