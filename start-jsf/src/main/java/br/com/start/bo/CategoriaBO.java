package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.CategoriaEntity;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class CategoriaBO implements Serializable, AppBO<CategoriaEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<CategoriaEntity> query;
		
	@Inject
	private PersistenceUtils<CategoriaEntity> dao;

	@Override
	public void save(CategoriaEntity categoria) {
		dao.save(categoria);
	}

	@Override
	public void remove(CategoriaEntity categoria) {
		dao.remove(categoria);
	}

	@Override
	public List<CategoriaEntity> all() {
		return query.all(CategoriaEntity.class);
	}

	@Override
	public List<CategoriaEntity> selected(String value) {
		return query.recuperaItem(CategoriaEntity.class, value, "descricao");
	}

	@Override
	public CategoriaEntity get(Long id) {
		return query.get(CategoriaEntity.class, id);
	}

}
