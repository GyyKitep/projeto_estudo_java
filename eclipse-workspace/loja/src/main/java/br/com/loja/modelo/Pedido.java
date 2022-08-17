package br.com.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
	
	//to one eager ->carrega todos os relacionamentos  por padrao
	//to many lazy -> so carrega se precisar 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;
	private LocalDate data = LocalDate.now();
	
	//@ManyToOne   //jpa sempre carrega esta informacao se for one to one tbm / já o one many ou many many nao carrega por trazer uma lista
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
									//cascade faz com que tudo que acontecer com a tabela pedidos seja feito com o item pedidos
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) //usado apenas quando tem relacao entre tabelas que estao que estao mapenadas
	private List<ItemPedido> itens = new ArrayList<>();

	public Pedido() {
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionarItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
		
	}

	public BigDecimal getPreco() {
		return valorTotal;
	}

	public void setPreco(BigDecimal preco) {
		this.valorTotal = preco;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
	
}
