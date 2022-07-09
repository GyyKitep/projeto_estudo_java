package br.com.loja.pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.loja.orcamento.Orcamento;
import br.com.loja.pedido.acao.AcaoAposGerarPedido;
import br.com.loja.pedido.acao.EnviarEmailPedido;
import br.com.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

public class GeraPedidoHandler{
	
	private List<AcaoAposGerarPedido> acoes;
	
	//construtor com injecao de dependencias: repository, service, etc.
	
	public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
		this.acoes = acoes;
	}
	
	public void execute(GeraPedido dados) {
		
		Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());
		String cliente = "Julio Junio";
		
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);
		
		acoes.forEach(a -> a.executarAcao(pedido));
			
	}

}
