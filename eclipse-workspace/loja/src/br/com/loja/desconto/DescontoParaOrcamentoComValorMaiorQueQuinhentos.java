package br.com.loja.desconto;

import java.math.BigDecimal;

import br.com.loja.orcamento.Orcamento;

public class DescontoParaOrcamentoComValorMaiorQueQuinhentos extends Desconto{
	
	
	public DescontoParaOrcamentoComValorMaiorQueQuinhentos(Desconto proximo) {
		super(proximo);
	}

	public BigDecimal efetuarCalculo(Orcamento orcamento) {		
		return orcamento.getValor().multiply(new BigDecimal("0.05"));
	}

	@Override
	public Boolean deveAplicar(Orcamento orcamento) {
		return orcamento.getValor().compareTo(new BigDecimal("500"))> 0;
	}

}
