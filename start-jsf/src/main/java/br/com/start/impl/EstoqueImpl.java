package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.EstoqueBO;
import br.com.start.entity.EstoqueEntity;
import br.com.start.facade.EstoqueFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class EstoqueImpl implements Serializable, EstoqueFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private EstoqueBO estoqueBO;

	@Transactional
	@Override
	public void save(EstoqueEntity estoque) {
		estoqueBO.save(estoque);
	}

	@Transactional
	@Override
	public void remove(EstoqueEntity estoque) {
		estoqueBO.remove(estoque);
	}

	@Override
	public List<EstoqueEntity> all() {
		return estoqueBO.all();
	}

	@Override
	public List<EstoqueEntity> selected(String value) {
		return estoqueBO.selected(value);
	}

	@Override
	public EstoqueEntity get(Long id) {
		return estoqueBO.get(id);
	}

}
