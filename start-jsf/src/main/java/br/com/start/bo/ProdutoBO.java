package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.as.ManutencaoProdutoAS;
import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.Produto;
import br.com.start.facade.AppBO;
import br.com.start.types.EntradaSaidaProduto;

@ApplicationScoped
public class ProdutoBO implements Serializable, AppBO<Produto> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private PersistenceUtils<Produto> dao;

	@Inject
	private QueryUtils<Produto> query;
	
	@Inject
	private ManutencaoProdutoAS produtoAS;
	

	@Override
	public void grava(Produto produto) {
		dao.save(produto);
	}

	@Override
	public void remove(Produto produto) {
		dao.remove(produto);
	}

	@Override
	public Produto get(Long id) {
		return query.get(Produto.class, id);
	}

	@Override
	public List<Produto> all() {
		return query.all(Produto.class);
	}

	@Override
	public List<Produto> selected(String value) {
		return query.recuperaItem(Produto.class, value, "descricao");
	}

	public Produto recuperaProduto(Long id) {
		return query.get(Produto.class, id);
	}
	
	public void entradaSaidaProduto(Produto produto, EntradaSaidaProduto entradaSaidaProduto) {
		produtoAS.entradaSaidaProduto(produto, entradaSaidaProduto);
	}

}
