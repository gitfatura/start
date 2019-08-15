package br.com.start.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.start.comum.AppBaseEntity;
import br.com.start.types.StatusOrcamento;

@Entity
@Table(name = "TB_ORCAMENTO")
public class OrcamentoEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = 1503752441249011654L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORC_ID")
	private Long id;

	@Column(name = "ORC_EMISSAO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataEmissao = new Date();

	@Column(name = "ORC_SOLICITANTE", nullable = false, length = 60)
	private String solicitante;

	@Column(name = "ORC_EMAIL", nullable = true, length = 100)
	private String email;

	@Column(name = "ORC_OBSERVACAO", nullable = true, length = 200)
	private String observacao;

	@Column(name = "ORC_VALOR", nullable = true)
	private BigDecimal valorTotal;

	@Column(name = "ORC_STATUS", nullable = false, length = 100)
	@Enumerated(EnumType.STRING)
	private StatusOrcamento status;


	public OrcamentoEntity() {
	}

	public OrcamentoEntity(Long id, Date dataEmissao, String solicitante, String email, String observacao,
			BigDecimal valorTotal, StatusOrcamento status) {
		this.id = id;
		this.dataEmissao = dataEmissao;
		this.solicitante = solicitante;
		this.email = email;
		this.observacao = observacao;
		this.valorTotal = valorTotal;
		this.status = status;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusOrcamento getStatus() {
		return status;
	}

	public void setStatus(StatusOrcamento status) {
		this.status = status;
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
		OrcamentoEntity other = (OrcamentoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
