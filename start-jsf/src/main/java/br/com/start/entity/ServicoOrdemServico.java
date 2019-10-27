package br.com.start.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
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

import br.com.start.types.Status;

@Entity
@Table(name = "TB_SERVICO_ORDEM_SERVICO")
public class ServicoOrdemServico extends AppBase implements Serializable {

	private static final long serialVersionUID = 6335889376602448547L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SOR_ID")
	private Long id;

	@ManyToOne(targetEntity = OrdemServico.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "SOR_ORDEMSERVICOID")
	private OrdemServico ordemServico;

	@ManyToOne(targetEntity = Servico.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "SOR_SERVICOID")
	private Servico servico;

	@Column(name = "SOR_VALOR")
	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	@Column(name = "SOR_STATUS", length = 20)
	private Status status = Status.ABERTO;

	public ServicoOrdemServico() {
	}

	public ServicoOrdemServico(Long id, OrdemServico ordemServico, Servico servico, BigDecimal valor, Status status) {
		this.id = id;
		this.ordemServico = ordemServico;
		this.servico = servico;
		this.valor = valor;
		this.status = status;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
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
		ServicoOrdemServico other = (ServicoOrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
