package br.com.start.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.Pessoa;
import br.com.start.entity.Usuario;
import br.com.start.facade.UsuarioFacade;

@ViewScoped
@Named
public class UsuarioConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private Usuario usuario;

	@Inject
	private Pessoa pessoa;

	@Inject
	private UsuarioFacade usuarioFacade;

	private List<Pessoa> pessoas;

	private List<Usuario> usuarios;

	private String valorPesquisaStr;

	@PostConstruct
	public void start() {
		recuperaUsuarios();
	}
	
	public void recuperaUsuarios() {
		usuarios = usuarioFacade.recuperaUsuarios(valorPesquisaStr);
	}

	public void remove() {
		usuarioFacade.remove(usuario);
		FacesUtil.addInfoMessage("Registro removido com sucesso!");
		usuario = new Usuario();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String getValorPesquisaStr() {
		return valorPesquisaStr;
	}

	public void setValorPesquisaStr(String valorPesquisaStr) {
		this.valorPesquisaStr = valorPesquisaStr;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
