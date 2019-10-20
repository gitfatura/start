package br.com.start.entity;

import java.io.Serializable;

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

import br.com.start.types.Finalizado;

@Entity
@Table(name = "TB_ORDEM_SERVICO")
public class OrdemServico extends AppBase implements Serializable {

	private static final long serialVersionUID = 6335889376602448547L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORD_ID")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "ORD_FINALIZADO", length = 3)
	private Finalizado finalizado = Finalizado.NAO;

	@ManyToOne(targetEntity = Veiculo.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "ORD_VEICULOID")
	private Veiculo veiculo;

	@ManyToOne(targetEntity = Servico.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "ORD_SERVICOID")
	private Servico servico;

	@ManyToOne(targetEntity = Pessoa.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "ORD_PESID")
	private Pessoa pessoa;

	@Column(name = "ORD_OBSERVACAO", length = 255)
	private String observacao;

	public OrdemServico() {
	}

	public OrdemServico(Long id, Finalizado finalizado, Veiculo veiculo, Servico servico, Pessoa pessoa,
			String observacao) {
		super();
		this.id = id;
		this.finalizado = finalizado;
		this.veiculo = veiculo;
		this.servico = servico;
		this.pessoa = pessoa;
		this.observacao = observacao;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Finalizado getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Finalizado finalizado) {
		this.finalizado = finalizado;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
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
