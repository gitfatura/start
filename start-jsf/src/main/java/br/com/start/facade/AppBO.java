package br.com.start.facade;

import java.util.List;

import br.com.start.entity.ProdutoEntity;

public interface AppBO<T> {

	default void save(T t) {}

	default List<T> all(){return null;}

	default void remove(T t) {}
	
	default List<T> selected(String value){return null;}

	default T get(Long id) {return null;}
	
	default void entradaProduto(ProdutoEntity produto) {	}
	
	default void saidaProduto(ProdutoEntity produto) {	}
	
	
	
}
