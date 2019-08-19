package br.com.start.impl;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import br.com.start.bo.ProdutoBO;
import br.com.start.entity.Produto;
import br.com.start.facade.ProdutoFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class ProdutoImpl implements Serializable, ProdutoFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private ProdutoBO produtoBO;

	@Transactional
	@Override
	public void grava(Produto produto) {
		produtoBO.grava(produto);
	}

	@Transactional
	@Override
	public void remove(Produto produto) {
		produtoBO.remove(produto);
	}

	@Transactional
	@Override
	public void entradaProduto(Produto produto) {
	}

	@Transactional
	@Override
	public void saidaProduto(Produto produto) {
	}

	@Override
	public Produto get(Long id) {
		return produtoBO.get(id);
	}

	@Override
	public List<Produto> all() {
		return produtoBO.all();
	}

	@Override
	public List<Produto> selected(String value) {
		return produtoBO.selected(value);
	}

	@Override
	public Produto recuperaProduto(Long id) {
		return produtoBO.recuperaProduto(id);
	}

}
