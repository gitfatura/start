package br.com.start.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.start.types.Status;

@Entity
@Table(name = "TB_ORDEM_SERVICO")
public class OrdemServico extends AppBase implements Serializable {

	private static final long serialVersionUID = 6335889376602448547L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORD_ID")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "ORD_STATUS", length = 20)
	private Status status = Status.ABERTO;

	@ManyToOne(targetEntity = Veiculo.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "ORD_VEICULOID")
	private Veiculo veiculo;

	@Temporal(TemporalType.DATE)
	@Column(name = "ORD_DATA")
	private Date data = Calendar.getInstance().getTime();

	@Column(name = "ORD_VALORTOTAL")
	private BigDecimal valorTotal;

	@Column(name = "ORD_OBSERVACAO", length = 255)
	private String observacao;

	@OneToMany(targetEntity = ServicoOrdemServico.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "ordemServico")
	private List<ServicoOrdemServico> servicoOrdemServicos;

	public OrdemServico() {
	}

	public OrdemServico(Long id, Status status, Veiculo veiculo, Date data, BigDecimal valorTotal, String observacao,
			List<ServicoOrdemServico> servicoOrdemServicos) {
		this.id = id;
		this.status = status;
		this.veiculo = veiculo;
		this.data = data;
		this.valorTotal = valorTotal;
		this.observacao = observacao;
		this.servicoOrdemServicos = servicoOrdemServicos;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<ServicoOrdemServico> getServicoOrdemServicos() {
		return servicoOrdemServicos;
	}

	public void setServicoOrdemServicos(List<ServicoOrdemServico> servicoOrdemServicos) {
		this.servicoOrdemServicos = servicoOrdemServicos;
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
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
