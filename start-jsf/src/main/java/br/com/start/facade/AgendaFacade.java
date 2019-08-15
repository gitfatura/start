package br.com.start.facade;

import java.util.List;

import br.com.start.entity.AgendaContadoEntity;

public interface AgendaFacade {

	public void save(AgendaContadoEntity agenda);

	public List<AgendaContadoEntity> all();

	public void remove(AgendaContadoEntity categoria);

	public List<AgendaContadoEntity> selected(String value);

	public AgendaContadoEntity get(Long id);

}
