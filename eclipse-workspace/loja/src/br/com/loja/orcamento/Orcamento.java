package br.com.loja.orcamento;

import java.math.BigDecimal;

import br.com.loja.orcamento.situacao.EmAnalise;
import br.com.loja.orcamento.situacao.SituacaoOrcamento;

public class Orcamento {
	
	private BigDecimal valor;
	private int quantidadeItens;
	private SituacaoOrcamento situacao;
	
	public Orcamento(BigDecimal valor, int quantidadeItens) {
		this.valor = valor;
		this.quantidadeItens = quantidadeItens;
		this.situacao = new EmAnalise();
	}
	
	public void aplicarDescontoExtra() {
		BigDecimal valorDoDescontoExtra = this.situacao.calcularValorDescontoExtra(this);				
		this.valor = this.valor.subtract(valorDoDescontoExtra);
	}
	
	public void aprovar() {
		this.situacao.aprovar(this);
	}
	
	public void reprovar() {
		this.situacao.reprovar(this);
	}
	
	public BigDecimal getValor() {
		return this.valor;
	}
	
	public int getQuantidadeItens() {
		return this.quantidadeItens;
	}
	
	public SituacaoOrcamento getSituacao() {
		return situacao;
	}
	
	public void setSituacao(SituacaoOrcamento situacao) {
		this.situacao = situacao;
	}
	

}
