package br.com.start.as;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.entity.Produto;
import br.com.start.types.EntradaSaidaProduto;

@ApplicationScoped
public class ManutencaoProdutoAS implements Serializable {

	private static final long serialVersionUID = -2096894550279202049L;

	@Inject
	private PersistenceUtils<Produto> dao;

	public void entradaSaidaProduto(Produto produto, EntradaSaidaProduto entradaSaidaProduto) {
		if (EntradaSaidaProduto.ENTRADA.equals(entradaSaidaProduto)) {
			dao.entradaProduto(produto);
		}
		if (EntradaSaidaProduto.SAIDA.equals(entradaSaidaProduto)) {
			dao.saidaProduto(produto);
		}

	}

}
