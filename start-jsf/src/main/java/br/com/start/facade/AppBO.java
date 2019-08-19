package br.com.start.facade;

import java.util.List;

public interface AppBO<T> {

	default void grava(T t) {}
	default List<T> all(){return null;}
	default void remove(T t) {}
	default List<T> selected(String value){return null;}
	default T get(Long id) {return null;}
	
}
