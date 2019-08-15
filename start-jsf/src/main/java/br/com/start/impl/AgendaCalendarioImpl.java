package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.AgendaCalendarioBO;
import br.com.start.entity.AgendaxpEntity;
import br.com.start.facade.AgendaCalendarioFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class AgendaCalendarioImpl implements Serializable, AgendaCalendarioFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private AgendaCalendarioBO agendaBO;

	@Transactional
	@Override
	public void save(AgendaxpEntity agenda) {
		agendaBO.save(agenda);
	}

	@Transactional
	@Override
	public void remove(AgendaxpEntity agenda) {
		agendaBO.remove(agenda);
	}

	@Override
	public List<AgendaxpEntity> all() {
		return agendaBO.all();
	}

	@Override
	public List<AgendaxpEntity> selected(String value) {
		return agendaBO.selected(value);
	}

	@Override
	public AgendaxpEntity get(Long id) {
		return agendaBO.get(id);
	}

}
