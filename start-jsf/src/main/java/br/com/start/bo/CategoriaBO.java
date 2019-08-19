package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.Categoria;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class CategoriaBO implements Serializable, AppBO<Categoria> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<Categoria> query;

	@Inject
	private PersistenceUtils<Categoria> dao;

	@Override
	public void grava(Categoria categoria) {
		dao.save(categoria);
	}

	@Override
	public void remove(Categoria categoria) {
		dao.remove(categoria);
	}

	@Override
	public List<Categoria> all() {
		return query.all(Categoria.class);
	}

	@Override
	public List<Categoria> selected(String value) {
		return query.recuperaItem(Categoria.class, value, "descricao");
	}

	@Override
	public Categoria get(Long id) {
		return query.get(Categoria.class, id);
	}

}
