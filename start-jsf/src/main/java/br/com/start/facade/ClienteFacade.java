package br.com.start.facade;

import java.util.List;

import br.com.start.entity.ClienteEntity;

public interface ClienteFacade {

	public void save(ClienteEntity cliente);

	public List<ClienteEntity> all();

	public void remove(ClienteEntity cliente);

	public List<ClienteEntity> selected(String value);

	public ClienteEntity get(Long id);

}
