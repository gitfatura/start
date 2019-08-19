package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import br.com.start.bo.CategoriaBO;
import br.com.start.entity.Categoria;
import br.com.start.facade.CategoriaFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class CategoriaImpl implements Serializable, CategoriaFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private CategoriaBO categoriaBO;

	@Transactional
	@Override
	public void grava(Categoria categoria) {
		categoriaBO.grava(categoria);
	}

	@Transactional
	@Override
	public void remove(Categoria categoria) {
		categoriaBO.remove(categoria);
	}

	@Override
	public List<Categoria> all() {
		return categoriaBO.all();
	}

	@Override
	public List<Categoria> selected(String value) {
		return categoriaBO.selected(value);
	}

	@Override
	public Categoria get(Long id) {
		return categoriaBO.get(id);
	}

}
