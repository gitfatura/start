package br.com.start.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.start.types.Sexo;
import br.com.start.types.TipoPessoa;

@Entity
@Table(name = "TB_PESSOA")
public class Pessoa extends AppBase implements Serializable {

	private static final long serialVersionUID = 1503752441249011654L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PES_ID")
	private Long id;

	@Column(name = "PES_NOME")
	private String nome;

	@Column(name = "PES_CPF", length = 14)
	private String cpf;

	@Column(name = "PES_CNPJ", length = 20)
	private String cnpj;

	@Column(name = "PES_RG", length = 20)
	private String rg;

	@Enumerated(EnumType.STRING)
	@Column(name = "PES_SEXO")
	private Sexo sexo;

	@Column(name = "PES_TELEFONE", length = 20)
	private String telefone;

	@Column(name = "PES_CELULAR", length = 20)
	private String celular;

	@Column(name = "PES_EMAIL")
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "PES_TIPOPESSOA")
	private TipoPessoa tipoPessoa;

	@OneToMany(targetEntity = Veiculo.class, fetch = FetchType.LAZY, mappedBy = "pessoa")
	private List<Veiculo> veiculos;

	@OneToMany(targetEntity = OrdemServico.class, fetch = FetchType.LAZY, mappedBy = "pessoa")
	private List<OrdemServico> ordemServicos;

	public Pessoa() {
	}

	public Pessoa(Long id, String nome, String cpf, String cnpj, String rg, Sexo sexo, String telefone, String celular,
			String email, TipoPessoa tipoPessoa, List<Veiculo> veiculos, List<OrdemServico> ordemServicos) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.rg = rg;
		this.sexo = sexo;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.tipoPessoa = tipoPessoa;
		this.veiculos = veiculos;
		this.ordemServicos = ordemServicos;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public List<OrdemServico> getOrdemServicos() {
		return ordemServicos;
	}

	public void setOrdemServicos(List<OrdemServico> ordemServicos) {
		this.ordemServicos = ordemServicos;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
