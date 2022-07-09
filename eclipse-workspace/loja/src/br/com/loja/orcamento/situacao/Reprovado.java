package br.com.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.loja.orcamento.Orcamento;

public class Reprovado extends SituacaoOrcamento{
	
	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.setSituacao(new Finalizado());
	}

}
