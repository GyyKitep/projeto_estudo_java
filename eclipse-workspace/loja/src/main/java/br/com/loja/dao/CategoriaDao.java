package br.com.loja.dao;

import javax.persistence.EntityManager;

import br.com.loja.modelo.Categoria;

public class CategoriaDao {
	
	private EntityManager em;
	
	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);//insere a informacao no banco configurado, ele insere conforme declarado na classe que manda gravar
								   //muda o atribudo para managed
	}
	
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);//retorna um atributo detached para managed
	}
	
	public void remover(Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);
	}	
}
