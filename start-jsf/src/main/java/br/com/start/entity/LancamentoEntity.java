package br.com.start.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.start.comum.AppBaseEntity;
import br.com.start.types.OpcaoLancamento;
import br.com.start.types.TipoLancamento;

@Entity
@Table(name = "TB_LANCAMENTO")
public class LancamentoEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = 1503752441249011654L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LAN_ID")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "LAN_TIPLANCAMENTO", nullable = false)
	private TipoLancamento tipoLancamento; // 1 saida - 2 entrada

	@Column(name = "LAN_TITULO", nullable = false, length = 60)
	private String titulo;

	@Column(name = "LAN_VALPREVISTO", nullable = false)
	private BigDecimal valorPrevisto;

	@Column(name = "LAN_VALREALIZADO", nullable = false)
	private BigDecimal valorRealizado;

	@Column(name = "LAN_DESCRICAO", nullable = true, length = 100)
	private String descricao;

	@Column(name = "LAN_DATA", nullable = false)
	private Date data = Calendar.getInstance().getTime();

	@Enumerated(EnumType.STRING)
	@Column(name = "LAN_OPCAOLANCAMENTO", nullable = true)
	private OpcaoLancamento opcaoLancamento; // 1 lancamento unico - 2 lancamento parcela

	@Column(name = "LAN_QUANTPARCELA", nullable = true)
	private Integer quantParcela; // numero de parcela

	public LancamentoEntity() {
	}

	public LancamentoEntity(Long id, TipoLancamento tipoLancamento, String titulo, BigDecimal valorPrevisto,
			BigDecimal valorRealizado, String descricao, Date data, OpcaoLancamento opcaoLancamento,
			Integer quantParcela) {
		super();
		this.id = id;
		this.tipoLancamento = tipoLancamento;
		this.titulo = titulo;
		this.valorPrevisto = valorPrevisto;
		this.valorRealizado = valorRealizado;
		this.descricao = descricao;
		this.data = data;
		this.opcaoLancamento = opcaoLancamento;
		this.quantParcela = quantParcela;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getValorPrevisto() {
		return valorPrevisto;
	}

	public void setValorPrevisto(BigDecimal valorPrevisto) {
		this.valorPrevisto = valorPrevisto;
	}

	public BigDecimal getValorRealizado() {
		return valorRealizado;
	}

	public void setValorRealizado(BigDecimal valorRealizado) {
		this.valorRealizado = valorRealizado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public OpcaoLancamento getOpcaoLancamento() {
		return opcaoLancamento;
	}

	public void setOpcaoLancamento(OpcaoLancamento opcaoLancamento) {
		this.opcaoLancamento = opcaoLancamento;
	}

	public Integer getQuantParcela() {
		return quantParcela;
	}

	public void setQuantParcela(Integer quantParcela) {
		this.quantParcela = quantParcela;
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
		LancamentoEntity other = (LancamentoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
