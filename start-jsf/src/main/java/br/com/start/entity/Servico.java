package br.com.start.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.start.types.Status;

@Entity
@Table(name = "TB_SERVICO")
public class Servico extends AppBase implements Serializable {

	private static final long serialVersionUID = -457217338300340483L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SER_ID")
	private Long id;

	@Column(name = "SER_CODIGO", length = 30)
	private String codigo;

	@Column(name = "SER_DESCRICAO", length = 100)
	private String descricao;

	@Column(name = "SER_VALOR")
	private BigDecimal valor;
	
	@Transient
	private Status status = Status.ABERTO;

	public Servico() {
	}

	public Servico(Long id, String codigo, String descricao, BigDecimal valor, Status status) {
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		Servico other = (Servico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}