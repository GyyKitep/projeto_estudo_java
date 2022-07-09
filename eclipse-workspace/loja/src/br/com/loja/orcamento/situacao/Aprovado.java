package br.com.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.loja.orcamento.Orcamento;

public class Aprovado extends SituacaoOrcamento{
	
	public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.05"));
	}
	
	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.setSituacao(new Finalizado());
	}

}
