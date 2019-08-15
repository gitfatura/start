package br.com.start.bo;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.QueryUtils;
import br.com.start.entity.UsuarioEntity;

@ApplicationScoped
public class UsuarioBO  implements Serializable{

	private static final long serialVersionUID = -6618559401038628743L;

	@Inject
	private QueryUtils<UsuarioEntity> query;

	public boolean validarUsuarioESenha(UsuarioEntity usuario) {
		return query.validarUsuarioESenha(usuario);
	}
	
}
