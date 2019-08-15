package br.com.start.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.start.comum.AppBaseEntity;
import br.com.start.types.Avaria;
import br.com.start.types.Finalizado;

@Entity
@Table(name = "TB_ORDEMSERVICO")
public class OrdemServicoEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = 6335889376602448547L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OSER_ID")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "OSER_FINALIZADO", length = 10)
	private Finalizado finalizado = Finalizado.NAO;

	@Column(name = "OSER_OBSERVACAO", length = 200)
	private String observacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "ORSE_AVARIA", length = 100)
	private Avaria avaria;

	public OrdemServicoEntity() {
	}

	public OrdemServicoEntity(Long id, Finalizado finalizado, String observacao, Avaria avaria, ServicoEntity servico) {
		this.id = id;
		this.finalizado = finalizado;
		this.observacao = observacao;
		this.avaria = avaria;
	}

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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Avaria getAvaria() {
		return avaria;
	}

	public void setAvaria(Avaria avaria) {
		this.avaria = avaria;
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
		OrdemServicoEntity other = (OrdemServicoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
