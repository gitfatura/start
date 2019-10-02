package br.com.start.bo;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.QueryUtils;
import br.com.start.entity.Usuario;

@ApplicationScoped
public class UsuarioBO implements Serializable {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<Usuario> query;
		
	public Usuario logar(Usuario usuario) {
		return query.logar(usuario);
	}

}
