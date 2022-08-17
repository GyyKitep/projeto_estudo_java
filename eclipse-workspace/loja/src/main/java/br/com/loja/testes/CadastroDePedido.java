package br.com.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ClienteDao;
import br.com.loja.dao.PedidoDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.CategoriaId;
import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.ItemPedido;
import br.com.loja.modelo.Pedido;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;
import br.com.loja.vo.RelatorioDeVendasVo;

public class CadastroDePedido {

	public static void main(String[] args) {
		popularBancoDeDados();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);		
		Produto produto = produtoDao.buscarPorId(1l);
		
		ClienteDao clienteDao = new ClienteDao(em);
		Cliente cliente = clienteDao.buscarPorId(1l);
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		
		em.getTransaction().begin(); 
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);
		
		em.getTransaction().commit();
		
		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		System.out.println("Total Vendido: " + totalVendido);
		
		List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
		relatorio.forEach(r -> System.out.println(r.toString()));
	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES", "CEL");
		
		Produto celular = new Produto("Xiaomi Redmi","Celular Preto", new BigDecimal("800"), celulares);

		 
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		Cliente cliente = new Cliente("Rodigo","123456");
		ClienteDao clienteDao = new ClienteDao(em);
		
		em.getTransaction().begin(); 
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular); 
		clienteDao.cadastrar(cliente);
		em.getTransaction().commit();
		
		em.find(Categoria.class, new CategoriaId("CELULARES", "CEL"));
		
		
		em.close();
	}
}
