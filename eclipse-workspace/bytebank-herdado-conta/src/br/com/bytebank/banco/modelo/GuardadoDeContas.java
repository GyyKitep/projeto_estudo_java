package br.com.bytebank.banco.modelo;

public class GuardadoDeContas {

	private Conta[] referencias;
	private int posicaoLivre; 
	
	public GuardadoDeContas(int colunas){
		
		this.referencias = new Conta[colunas];
		this.posicaoLivre = 0;
		
	}
	
	public void adiciona(Conta ref){
		
		this.referencias[this.posicaoLivre] = ref;
		this.posicaoLivre ++;
		
	}

	public int getQuantidadeDeElementos(){
		
		return this.posicaoLivre;
		
	}

	public Conta getReferencia(int pos) {
		return this.referencias[pos];
	}	

}
