package br.com.start.facade;

import java.util.List;

import br.com.start.entity.AgendaxpEntity;

public interface AgendaCalendarioFacade {

	public void save(AgendaxpEntity agenda);

	public List<AgendaxpEntity> all();

	public void remove(AgendaxpEntity categoria);

	public List<AgendaxpEntity> selected(String value);

	public AgendaxpEntity get(Long id);

}
