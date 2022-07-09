package br.com.loja.desconto;

import java.math.BigDecimal;

import br.com.loja.orcamento.Orcamento;

public class SemDesconto extends Desconto{
	
	
	public SemDesconto(Desconto proximo) {
		super(null);
	}

	public BigDecimal efetuarCalculo(Orcamento orcamento) {
		return BigDecimal.ZERO;
		
	}

	@Override
	public Boolean deveAplicar(Orcamento orcamento) {
		return true;
	}

}
