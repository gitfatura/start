package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.AgendaxpEntity;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class AgendaCalendarioBO implements Serializable, AppBO<AgendaxpEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<AgendaxpEntity> query;
		
	@Inject
	private PersistenceUtils<AgendaxpEntity> dao;
	
	@Override
	public void save(AgendaxpEntity agenda) {
		dao.save(agenda);
	}

	@Override
	public void remove(AgendaxpEntity agenda) {
		dao.remove(agenda);
	}

	@Override
	public List<AgendaxpEntity> all() {
		return query.all(AgendaxpEntity.class);
	}

	@Override
	public List<AgendaxpEntity> selected(String value) {
		return query.recuperaItem(AgendaxpEntity.class, value, "nome");
	}

	@Override
	public AgendaxpEntity get(Long id) {
		return query.get(AgendaxpEntity.class, id);
	}

}
