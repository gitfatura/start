package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.DespesaBO;
import br.com.start.entity.DespesaEntity;
import br.com.start.facade.DespesaFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class DespesaImpl implements Serializable, DespesaFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private DespesaBO despesaBO;

	@Transactional
	@Override
	public void save(DespesaEntity despesa) {
		despesaBO.save(despesa);
	}

	@Transactional
	@Override
	public void remove(DespesaEntity despesa) {
		despesaBO.remove(despesa);
	}

	@Override
	public List<DespesaEntity> all() {
		return despesaBO.all();
	}

	@Override
	public List<DespesaEntity> selected(String value) {
		return despesaBO.selected(value);
	}

	@Override
	public DespesaEntity get(Long id) {
		return despesaBO.get(id);
	}

}
