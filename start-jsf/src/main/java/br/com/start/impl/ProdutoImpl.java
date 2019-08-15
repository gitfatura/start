package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.ProdutoBO;
import br.com.start.entity.ProdutoEntity;
import br.com.start.facade.ProdutoFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class ProdutoImpl implements Serializable, ProdutoFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private ProdutoBO produtoBO;

	@Transactional
	@Override
	public void save(ProdutoEntity produto) {
		produtoBO.save(produto);
	}

	@Transactional
	@Override
	public void remove(ProdutoEntity produto) {
		produtoBO.remove(produto);
	}
	
	@Transactional
	@Override
	public void entradaProduto(ProdutoEntity produto) {
		produtoBO.entradaProduto(produto);
	}
	
	@Transactional
	@Override
	public void saidaProduto(ProdutoEntity produto) {
		produtoBO.saidaProduto(produto);
	}
	
	@Override
	public ProdutoEntity get(Long id) {
		return produtoBO.get(id);
	}

	@Override
	public List<ProdutoEntity> all() {
		return produtoBO.all();
	}

	@Override
	public List<ProdutoEntity> selected(String value) {
		return produtoBO.selected(value);
	}

	@Override
	public ProdutoEntity recuperaProduto(Long id) {
		return produtoBO.recuperaProduto(id);
	}

}
