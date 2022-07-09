package br.com.loja.desconto;

import java.math.BigDecimal;

import br.com.loja.orcamento.Orcamento;

public class DescontoParaOrcamentoComMaisDeCincoItens extends Desconto{
	
	
	public DescontoParaOrcamentoComMaisDeCincoItens(Desconto proximo) {
		super(proximo);
	}

	public BigDecimal efetuarCalculo(Orcamento orcamento) {
				
		return orcamento.getValor().multiply(new BigDecimal("0.1"));
			
	}

	@Override
	public Boolean deveAplicar(Orcamento orcamento) {
		return orcamento.getQuantidadeItens()> 5;
	}

}
