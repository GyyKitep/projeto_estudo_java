package br.com.loja;

public class DomainExcepction extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DomainExcepction(String mensagem) {
		super(mensagem);
	}

}
