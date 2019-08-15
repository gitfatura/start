package br.com.start.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.start.comum.AppBaseEntity;
import br.com.start.types.FormaPagamento;
import br.com.start.types.SituacaoDaContaAPagar;

@Entity
@Table(name = "TB_CONTAPAGAR")
public class ContaAPagarEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = -6047604278837617042L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CON_ID")
	private Long id;

	@Column(name = "CON_DESCRICAO", length = 200, nullable = false)
	private String descricao;

	@Temporal(TemporalType.DATE)
	@Column(name = "CON_DATAVENCIMENTO", nullable = true)
	private Date dataVencimento;

	@Temporal(TemporalType.DATE)
	@Column(name = "CON_DATAPAGAMENTO", nullable = true)
	private Date dataPagamento;

	@Column(name = "CON_VALOR", nullable = true)
	private Double valor;

	@Enumerated(EnumType.STRING)
	@Column(name = "CON_FORMAPAGAMENTO", nullable = true, length = 60)
	private FormaPagamento formaPagamento = FormaPagamento.DINHEIRO;

	@Enumerated(EnumType.STRING)
	@Column(name = "CON_SITUACAO", length = 60, nullable = true)
	private SituacaoDaContaAPagar situacao = SituacaoDaContaAPagar.ABERTA;

	@Column(name = "CON_OBSERVACAO", length = 200, nullable = true)
	private String observacao;

	@ManyToOne(targetEntity = FornecedorEntity.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "CON_FORNECEDORID", referencedColumnName = "FOR_ID")
	private FornecedorEntity fornecedor;

	public ContaAPagarEntity() {
	}

	public ContaAPagarEntity(Long id, FornecedorEntity fornecedor, String descricao, Date dataVencimento,
			Date dataPagamento, Double valor, FormaPagamento formaPagamento, SituacaoDaContaAPagar situacao,
			String observacao) {
		super();
		this.id = id;
		this.fornecedor = fornecedor;
		this.descricao = descricao;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
		this.situacao = situacao;
		this.observacao = observacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FornecedorEntity getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(FornecedorEntity fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public SituacaoDaContaAPagar getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoDaContaAPagar situacao) {
		this.situacao = situacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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
		ContaAPagarEntity other = (ContaAPagarEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
