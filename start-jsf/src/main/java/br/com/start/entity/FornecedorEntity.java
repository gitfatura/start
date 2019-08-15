package br.com.start.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import br.com.start.comum.AppBaseEntity;

@Entity
@Table(name = "TB_FORNECEDOR")
public class FornecedorEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = -6521750621480073952L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FOR_ID")
	private Long id;

	@Column(name = "FOR_NOME", nullable = false, length = 60)
	private String nome;

	@Column(name = "FOR_CNPJ", nullable = true, length = 20)
	private String cnpj;

	@Column(name = "FOR_TELEFONE", nullable = true, length = 15)
	private String telefone;

	@Column(name = "FOR_CELULAR", nullable = true, length = 15)
	private String celular;

	@Column(name = "FOR_EMAIL", nullable = true, length = 60)
	private String email;

	@Column(name = "FOR_ENDERECO", nullable = true, length = 100)
	private String endereco;

	@OneToMany(targetEntity = ContaAPagarEntity.class, fetch = FetchType.LAZY, mappedBy = "fornecedor")
	@Column(name = "CON_ID")
	private List<ContaAPagarEntity> contaAPagars;

	public FornecedorEntity() {
	}

	public FornecedorEntity(Long id, String nome, String cnpj, String telefone, String celular, String email,
			String endereco, List<ContaAPagarEntity> contaAPagars) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.endereco = endereco;
		this.contaAPagars = contaAPagars;
	}

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<ContaAPagarEntity> getContaAPagars() {
		return contaAPagars;
	}

	public void setContaAPagars(List<ContaAPagarEntity> contaAPagars) {
		this.contaAPagars = contaAPagars;
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
		FornecedorEntity other = (FornecedorEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
