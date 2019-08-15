package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.ClienteEntity;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class ClienteBO implements Serializable, AppBO<ClienteEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<ClienteEntity> query;
		
	@Inject
	private PersistenceUtils<ClienteEntity> dao;
	
	
	@Override
	public void save(ClienteEntity cliente) {
		dao.save(cliente);
	}

	@Override
	public void remove(ClienteEntity cliente) {
		dao.remove(cliente);
	}

	@Override
	public List<ClienteEntity> all() {
		return query.all(ClienteEntity.class);
	}

	@Override
	public List<ClienteEntity> selected(String value) {
		return query.recuperaItem(ClienteEntity.class, value, "nome");
	}

	@Override
	public ClienteEntity get(Long id) {
		return query.get(ClienteEntity.class, id);
	}

}
