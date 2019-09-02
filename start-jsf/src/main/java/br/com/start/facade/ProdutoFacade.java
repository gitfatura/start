package br.com.start.facade;

import java.util.List;
import br.com.start.entity.Produto;
import br.com.start.types.EntradaSaidaProduto;

public interface ProdutoFacade {
	public void grava(Produto produto);
	public List<Produto> all();
	public void remove(Produto produto);
	public List<Produto> selected(String value);
	public Produto get(Long id);
	public Produto recuperaProduto(Long id);
	default void entradaSaidaProduto(Produto produto, EntradaSaidaProduto entradaSaidaProduto) {	}
}
