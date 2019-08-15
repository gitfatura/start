package br.com.start.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.start.comum.AppBaseEntity;

@Entity
@Table(name = "TB_ESTOQUE")
public class EstoqueEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = 1503752441249011654L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EST_ID")
	private Long id;

	@Column(name = "EST_DESCRICAO", nullable = false, length = 60)
	private String descricao;

	@Column(name = "EST_LOCAL", nullable = false)
	private String local;

	@OneToMany(targetEntity = ProdutoEntity.class, fetch = FetchType.LAZY, mappedBy = "estoque")
	private List<ProdutoEntity> produtos;

	public EstoqueEntity() {
	}

	public EstoqueEntity(Long id, String descricao, String local, List<ProdutoEntity> produtos) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.local = local;
		this.produtos = produtos;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public List<ProdutoEntity> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoEntity> produtos) {
		this.produtos = produtos;
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
		EstoqueEntity other = (EstoqueEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
