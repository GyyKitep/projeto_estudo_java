package br.com.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		cadastrarProduto();	
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());	
		
		//List<Produto> todos = produtoDao.buscarTodos();
		List<Produto> todos = produtoDao.buscarPorNome("Xiaomi Redmi");
		
		todos.forEach(produto -> System.out.println(produto.getNome()));
		
		List<Produto> todos2 = produtoDao.buscarPorNomeDaCategoria("CELULARES");
		
		todos2.forEach(produto -> System.out.println(produto.getNome()));
		
		BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
		
		System.out.println(precoDoProduto);		
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES", "CEL");
		
		Produto celular = new Produto("Xiaomi Redmi","Celular Preto", new BigDecimal("800"), celulares);

		 
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin(); // precisa iniciar a operacao por causa da conf do banco
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular); 
		//celulares.setNome("xpto");  // da um update  por causa que ele nao foi commitado ainda
		
		em.getTransaction().commit();
		//em.flush();
		//em.clear();                    // tira tudo do managed para detached    
		     
		//categoriaDao.atualizar(celulares); nao funcionou
		//celulares = em.merge(celulares);
		//celulares.setNome("teste celular"); 
		//em.flush();
		
		//categoriaDao.remover(celulares);
		//em.flush();
		
		
		em.close();
	}

}
