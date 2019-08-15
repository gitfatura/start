package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.EstoqueEntity;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class EstoqueBO implements Serializable, AppBO<EstoqueEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<EstoqueEntity> query;
		
	@Inject
	private PersistenceUtils<EstoqueEntity> dao;


	@Override
	public void save(EstoqueEntity estoque) {
		dao.save(estoque);
	}

	@Override
	public void remove(EstoqueEntity estoque) {
		dao.remove(estoque);
	}

	@Override
	public List<EstoqueEntity> all() {
		return query.all(EstoqueEntity.class);
	}

	@Override
	public List<EstoqueEntity> selected(String value) {
		return query.recuperaItem(EstoqueEntity.class, value, "descricao");
	}

	@Override
	public EstoqueEntity get(Long id) {
		return query.get(EstoqueEntity.class, id);
	}

}
