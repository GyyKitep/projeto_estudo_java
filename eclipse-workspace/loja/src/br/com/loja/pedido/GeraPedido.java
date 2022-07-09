package br.com.loja.pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.loja.orcamento.Orcamento;

public class GeraPedido{
	
	private String cliente;
	private BigDecimal valorOrcamento;
	private int quantidadeItens;
	
	// injecao de depeendicas: PedidoRepository, EmailService, ....
	public GeraPedido(String cliente, BigDecimal valorOrcamento, int quantiadadeItens) {
		this.cliente = cliente;
		this.valorOrcamento = valorOrcamento;
		this.quantidadeItens = quantiadadeItens;
	}
	
//	public void executa() {
//		
//		Orcamento orcamento = new Orcamento(this.valorOrcamento, this.quantidadeItens);
//		String cliente = "Julio Junio";
//		
//		Pedido pedido = new Pedido(cliente, LocalDateTime.now(), orcamento);
//		
//		System.out.println("Salvar peeido no banco de dados");
//		System.out.println("Enviar email com dados do novo pedido");			
//	}
	
	public String getCliente() {
		return cliente;
	}
	
	public int getQuantidadeItens() {
		return quantidadeItens;
	}
	
	public BigDecimal getValorOrcamento() {
		return valorOrcamento;
	}
	

}
