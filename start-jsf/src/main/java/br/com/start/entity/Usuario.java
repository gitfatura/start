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

import br.com.start.types.Role;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -2094929034363252346L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USU_ID")
	private Long id;

	@Column(name = "USU_LOGIN", length = 100)
	private String login;

	@Column(name = "USU_SENHA", length = 100)
	private String senha;

	@Column(name = "USU_ROLE", length = 11)
	@Enumerated(EnumType.STRING)
	private Role role;

	@ManyToOne(targetEntity = Pessoa.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "USU_PESID")
	private Pessoa pessoa;

	public boolean isAdmin() {
		return Role.ADMIN.equals(role);
	}

	public boolean isFuncionario() {
		return Role.FUNCIONARIO.equals(role);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
