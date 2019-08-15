package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.ClienteBO;
import br.com.start.entity.ClienteEntity;
import br.com.start.facade.ClienteFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class ClienteImpl implements Serializable, ClienteFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private ClienteBO clienteBO;

	@Transactional
	@Override
	public void save(ClienteEntity cliente) {
		clienteBO.save(cliente);
	}

	@Transactional
	@Override
	public void remove(ClienteEntity cliente) {
		clienteBO.remove(cliente);
	}

	@Override
	public List<ClienteEntity> all() {
		return clienteBO.all();
	}

	@Override
	public List<ClienteEntity> selected(String value) {
		return clienteBO.selected(value);
	}

	@Override
	public ClienteEntity get(Long id) {
		return clienteBO.get(id);
	}

}
