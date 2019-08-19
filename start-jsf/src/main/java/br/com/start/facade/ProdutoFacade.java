package br.com.start.facade;

import java.util.List;
import br.com.start.entity.Produto;

public interface ProdutoFacade {
	public void grava(Produto produto);
	public List<Produto> all();
	public void remove(Produto produto);
	public List<Produto> selected(String value);
	public Produto get(Long id);
	public Produto recuperaProduto(Long id);
	default void entradaProduto(Produto produto) {	}
	default void saidaProduto(Produto produto) {	}
}
