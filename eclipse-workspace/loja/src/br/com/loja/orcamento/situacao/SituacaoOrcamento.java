package br.com.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.loja.DomainExcepction;
import br.com.loja.orcamento.Orcamento;

public abstract class SituacaoOrcamento {
	
	public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
		return BigDecimal.ZERO;
	}	
	
	public void aprovar(Orcamento orcamento) {
		throw new DomainExcepction("Orcamento nao pode ser aprovado!");
	}
	
	public void reprovar(Orcamento orcamento) {
		throw new DomainExcepction("Orcamento nao pode ser reprovado!");
	}	
	
	public void finalizar(Orcamento orcamento) {
		throw new DomainExcepction("Orcamento nao pode ser finalizado!");
	}	
}
