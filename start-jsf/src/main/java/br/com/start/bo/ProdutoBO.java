package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.ProdutoEntity;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class ProdutoBO implements Serializable, AppBO<ProdutoEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private PersistenceUtils<ProdutoEntity> dao;

	@Inject
	private QueryUtils<ProdutoEntity> query;

	@Override
	public void save(ProdutoEntity produto) {
		dao.save(produto);
	}

	@Override
	public void remove(ProdutoEntity produto) {
		dao.remove(produto);
	}

	@Override
	public ProdutoEntity get(Long id) {
		return query.get(ProdutoEntity.class, id);
	}

	@Override
	public List<ProdutoEntity> all() {
		return query.all(ProdutoEntity.class);
	}

	@Override
	public List<ProdutoEntity> selected(String value) {
		return query.recuperaItem(ProdutoEntity.class, value, "nome");
	}

	public ProdutoEntity recuperaProduto(Long id) {
		return query.get(ProdutoEntity.class, id);
	}

}
