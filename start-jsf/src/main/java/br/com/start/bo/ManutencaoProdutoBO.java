package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.Produto;

@ApplicationScoped
public class ManutencaoProdutoBO implements Serializable {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private PersistenceUtils<Produto> dao;

	@Inject
	private QueryUtils<Produto> query;

	public void entrada(Produto produto) {
		dao.entradaProduto(produto);
	}

	public void saida(Produto produto) {
		dao.saidaProduto(produto);
	}

	public Produto get(Long id) {
		return query.get(Produto.class, id);
	}

	public List<Produto> all() {
		return query.all(Produto.class);
	}

	public List<Produto> selected(String value) {
		return query.recuperaItem(Produto.class, value, "nome");
	}

}
