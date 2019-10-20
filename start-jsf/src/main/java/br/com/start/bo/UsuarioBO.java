package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.Usuario;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class UsuarioBO implements Serializable {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<Usuario> query;
	
	@Inject
	private PersistenceUtils<Usuario> dao;

	
	public Usuario logar(Usuario usuario) {
		return query.logar(usuario);
	}

	@Transactional
	public void grava(Usuario usuario) {
		dao.save(usuario);
	}
	
	public List<Usuario> recuperaUsuarios(String value){
		return query.recuperaUsuarios(value);
	}

	public void remove(Usuario usuario) {
		dao.remove(usuario);
	}
	
}
