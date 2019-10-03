package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.PessoaBO;
import br.com.start.bo.UsuarioBO;
import br.com.start.entity.Pessoa;
import br.com.start.entity.Usuario;
import br.com.start.facade.UsuarioFacade;

@ApplicationScoped
public class UsuarioImpl implements Serializable, UsuarioFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private UsuarioBO usuarioBO;
	
	@Inject
	private PessoaBO pessoaBO;
	
	@Override
	public Usuario logar(Usuario usuario) {
		return usuarioBO.logar(usuario);
	}

	@Override
	public List<Pessoa> selected(String value) {
		return pessoaBO.selected(value);
	}

}
