package br.com.start.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto extends AppBase implements Serializable {

	private static final long serialVersionUID = 1503752441249011654L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRO_ID")
	private Long id;

	@Column(name = "PRO_VALOR")
	private BigDecimal valor;

	@Column(name = "PRO_NOME")
	private String nome;

	@Column(name = "PRO_DESCRICAO")
	private String descricao;

	@Column(name = "PRO_DATA")
	private Date data = Calendar.getInstance().getTime();

	@Column(name = "PRO_QUANTIDADE")
	private Integer quantidade;

	@Column(name = "PRO_VALTOTAL")
	private BigDecimal valorTotal = BigDecimal.ZERO;

	@ManyToOne(targetEntity = Categoria.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRO_CATEGORIAID")
	private Categoria categoria;

	public Produto() {
	}

	public Produto(Long id, BigDecimal valor, String nome, String descricao, Date data, Integer quantidade,
			BigDecimal valorTotal, Categoria categoria) {
		this.id = id;
		this.valor = valor;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
		this.categoria = categoria;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
