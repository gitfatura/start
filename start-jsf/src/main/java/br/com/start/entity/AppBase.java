package br.com.start.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.start.facade.EntidadeBase;

@MappedSuperclass
public abstract class AppBase implements Serializable, EntidadeBase {

	private static final long serialVersionUID = -8041929115797201847L;

	@Column(name = "USU_ULT_ALTERCACAO", length=60)
	private String usuarioUltimaAlteracao ="usuarioLogado"; 

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ULT_ALTERACAO")
	private Date dataUltimaAlteracao = Calendar.getInstance().getTime();

	@Column(name = "ATIVO")
	private int ativo =1;

	public AppBase() {
	}

	public AppBase(String usuarioUltimaAlteracao, Date dataUltimaAlteracao, int ativo) {
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
