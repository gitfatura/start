package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.CategoriaBO;
import br.com.start.entity.CategoriaEntity;
import br.com.start.facade.CategoriaFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class CategoriaImpl implements Serializable, CategoriaFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private CategoriaBO categoriaBO;

	@Transactional
	@Override
	public void save(CategoriaEntity categoria) {
		categoriaBO.save(categoria);
	}

	@Transactional
	@Override
	public void remove(CategoriaEntity categoria) {
		categoriaBO.remove(categoria);
	}

	@Override
	public List<CategoriaEntity> all() {
		return categoriaBO.all();
	}

	@Override
	public List<CategoriaEntity> selected(String value) {
		return categoriaBO.selected(value);
	}

	@Override
	public CategoriaEntity get(Long id) {
		return categoriaBO.get(id);
	}

}
