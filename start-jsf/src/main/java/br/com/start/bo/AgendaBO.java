package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.AgendaContadoEntity;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class AgendaBO implements Serializable, AppBO<AgendaContadoEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<AgendaContadoEntity> query;
		
	@Inject
	private PersistenceUtils<AgendaContadoEntity> dao;
	 
	@Override
	public void save(AgendaContadoEntity agenda) {
		dao.save(agenda);
	}

	@Override
	public void remove(AgendaContadoEntity agenda) {
		dao.remove(agenda);
	}

	@Override
	public List<AgendaContadoEntity> all() {
		return query.all(AgendaContadoEntity.class);
	}

	@Override
	public List<AgendaContadoEntity> selected(String value) {
		return query.recuperaItem(AgendaContadoEntity.class, value, "nome");
	}

	@Override
	public AgendaContadoEntity get(Long id) {
		return query.get(AgendaContadoEntity.class, id);
	}

}
