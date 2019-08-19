package br.com.start.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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

import br.com.start.types.FormaPagamento;
import br.com.start.types.Situacao;
import br.com.start.types.TipoConta;

@Entity
@Table(name = "TB_CONTAPAGAR_RECEBER")
public class ContaPagarReceber extends AppBase implements Serializable {

	private static final long serialVersionUID = -6047604278837617042L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CON_ID")
	private Long id;

	@Column(name = "CON_DESCRICAO")
	private String descricao;

	@Temporal(TemporalType.DATE)
	@Column(name = "CON_VENCIMENTO")
	private Date dataVencimento;

	@Temporal(TemporalType.DATE)
	@Column(name = "CON_PAGAMENTO")
	private Date dataPagamento;

	@Column(name = "CON_VALOR")
	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	@Column(name = "CON_FORMAPAGAMENTO")
	private FormaPagamento formaPagamento = FormaPagamento.DINHEIRO;

	@Enumerated(EnumType.STRING)
	@Column(name = "CON_SITUACAO")
	private Situacao situacao = Situacao.ABERTA;

	@Enumerated(EnumType.STRING)
	@Column(name = "CON_TIPOCONTA")
	private TipoConta tipoConta = TipoConta.RECEBER;

	@Column(name = "CON_OBSERVACAO")
	private String observacao;

	@ManyToOne(targetEntity = Pessoa.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "CON_FORNECEDORID")
	private Pessoa pessoa;

	public ContaPagarReceber() {
	}

	public ContaPagarReceber(Long id, String descricao, Date dataVencimento, Date dataPagamento, BigDecimal valor,
			FormaPagamento formaPagamento, Situacao situacao, TipoConta tipoConta, String observacao, Pessoa pessoa) {
		this.id = id;
		this.descricao = descricao;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
		this.situacao = situacao;
		this.tipoConta = tipoConta;
		this.observacao = observacao;
		this.pessoa = pessoa;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
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
		ContaPagarReceber other = (ContaPagarReceber) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
