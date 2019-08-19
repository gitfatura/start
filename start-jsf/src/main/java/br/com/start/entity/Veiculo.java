package br.com.start.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_VEICULO")
public class Veiculo extends AppBase implements Serializable {

	private static final long serialVersionUID = -4865729194315901658L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VEI_ID")
	private Long id;

	@Column(name = "VEI_MARCA")
	private String marca;

	@Column(name = "VEI_MODELO")
	private String modelo;

	@Column(name = "VEI_PLACA")
	private String placa;

	@ManyToOne(targetEntity = Pessoa.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "VEI_PESID")
	private Pessoa pessoa;

	@OneToMany(targetEntity = Avaria.class, fetch = FetchType.LAZY, mappedBy = "veiculo")
	private List<Avaria> avarias;

	@OneToMany(targetEntity = OrdemServico.class, fetch = FetchType.LAZY, mappedBy = "veiculo")
	private List<OrdemServico> servicos;

	public Veiculo() {
	}

	public Veiculo(Long id, String marca, String modelo, String placa, Pessoa pessoa, List<Avaria> avarias,
			List<OrdemServico> servicos) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.pessoa = pessoa;
		this.avarias = avarias;
		this.servicos = servicos;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public List<Avaria> getAvarias() {
		return avarias;
	}

	public void setAvarias(List<Avaria> avarias) {
		this.avarias = avarias;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<OrdemServico> getServicos() {
		return servicos;
	}

	public void setServicos(List<OrdemServico> servicos) {
		this.servicos = servicos;
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
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
