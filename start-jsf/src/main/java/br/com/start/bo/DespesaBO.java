package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.DespesaEntity;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class DespesaBO implements Serializable, AppBO<DespesaEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<DespesaEntity> query;
		
	@Inject
	private PersistenceUtils<DespesaEntity> dao;

	@Override
	public void save(DespesaEntity despesa) {
		dao.save(despesa);
	}

	@Override
	public void remove(DespesaEntity despesa) {
		dao.remove(despesa);
	}

	@Override
	public List<DespesaEntity> all() {
		return query.all(DespesaEntity.class);
	}

	@Override
	public List<DespesaEntity> selected(String value) {
		return query.recuperaItem(DespesaEntity.class, value, "descricao");
	}

	@Override
	public DespesaEntity get(Long id) {
		return query.get(DespesaEntity.class, id);
	}

}
