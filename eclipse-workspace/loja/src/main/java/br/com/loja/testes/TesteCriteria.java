package br.com.loja.testes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;

public class TesteCriteria {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		produtoDao.buscarPorParametrosComCriteria(null, null, LocalDate.now());
	    
	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES", "CEl");
		Categoria videogames = new Categoria("VIDEOGAMES", "VIDEO");
		Categoria informatica = new Categoria("INFORMATICA", "INFOR");
		
		Produto celular = new Produto("Xiaomi Redmi", "Muito Legal", new BigDecimal(800), celulares);
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal(400), videogames);
		Produto macbook = new Produto("Macbook", "Macboo pro", new BigDecimal(200), informatica);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();;
		
		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(videogames);
		categoriaDao.cadastrar(informatica);
		
		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(videogame);
		produtoDao.cadastrar(macbook);
		
		em.getTransaction().commit();
	}

}
