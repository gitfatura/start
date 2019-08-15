package br.com.start.comum;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.start.facade.EntidadeBase;

@MappedSuperclass
public abstract class AppBaseEntity implements Serializable, EntidadeBase {

	private static final long serialVersionUID = -8041929115797201847L;

	@Column(name = "USU_ULTI_ALTERCACAO", length = 60, nullable = true)
	private String usuarioUltimaAlteracao ="usuarioLogado"; 

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ULTI_ALTERACAO", nullable = true)
	private Date dataUltimaAlteracao = new Date();

	@Column(name = "ATIVO", nullable = true, length = 60)
	private int ativo =1;

	public AppBaseEntity() {
	}

	public AppBaseEntity(String usuarioUltimaAlteracao, Date dataUltimaAlteracao, int ativo) {
		super();
		this.usuarioUltimaAlteracao = usuarioUltimaAlteracao;
		this.dataUltimaAlteracao = dataUltimaAlteracao;
		this.ativo = ativo;
	}

	public String getUsuarioUltimaAlteracao() {
		return usuarioUltimaAlteracao;
	}

	public void setUsuarioUltimaAlteracao(String usuarioUltimaAlteracao) {
		this.usuarioUltimaAlteracao = usuarioUltimaAlteracao;
	}

	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

}
