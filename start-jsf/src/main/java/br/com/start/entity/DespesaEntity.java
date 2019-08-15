package br.com.start.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.start.comum.AppBaseEntity;

@Entity
@Table(name = "TB_DESPESA")
public class DespesaEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = 1503752441249011654L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DES_ID")
	private Long id;

	@Column(name = "DES_DESCRICAO", nullable = false, length = 100)
	private String descricao;

	@Column(name = "DES_VALOR", nullable = false)
	private BigDecimal valor;

	@Column(name = "DES_DATVENCIMENTO", nullable = false)
	private Date dataVencimento;

	@Column(name = "DES_SITUACAO", nullable = false)
	private Integer situacao;

	@Column(name = "DES_QUANTIDADE")
	private Integer quantidade;

	public DespesaEntity() {
	}

	public DespesaEntity(Long id, String descricao, BigDecimal valor, Date dataVencimento, Integer situacao,
			Integer quantidade) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.situacao = situacao;
		this.quantidade = quantidade;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
		DespesaEntity other = (DespesaEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
