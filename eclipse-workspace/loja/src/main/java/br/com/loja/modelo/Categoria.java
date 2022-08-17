package br.com.loja.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	@EmbeddedId//quando mais de um tributo forma a chave primaria
	private CategoriaId id;

	
	public Categoria() {
	}
	
	public Categoria(String nome, String tipo) {
		this.id = new CategoriaId(nome, tipo);
	}
	
	private String getNome() {
		return id.getNome();
	}
	
	private String getTipo() {
		return id.getTipo();
	}

}
