package br.com.start.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.UsuarioBO;
import br.com.start.entity.UsuarioEntity;
import br.com.start.facade.UsuarioFacade;

@ApplicationScoped
public class UsuarioImpl implements Serializable, UsuarioFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private UsuarioBO usuarioBO;

	@Override
	public boolean validarUsuarioESenha(UsuarioEntity usuario) {
		return usuarioBO.validarUsuarioESenha(usuario) ;
	}

}
