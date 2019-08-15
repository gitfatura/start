package br.com.start.comum;

import java.util.List;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class CollectionsUtils<T> {

	/**
	 * Particiona uma lista
	 * 
	 * @param lista
	 * @param nPartes
	 * @return
	 */
	public static List<List<String>> partes(List<String> lista, int nPartes) {
		List<List<String>> resultado = Lists.partition(lista, nPartes);
		return resultado;
	}

	/**
	 * Remove todos os valores de uma lista
	 * 
	 * @param lista
	 * @return
	 */
	public static List<String> removeDuplicado(List<String> lista) {
		List<String> result = ImmutableSet.copyOf(lista).asList();
		return result;
	}

	/**
	 * Remove todos os nulos de uma lista
	 * 
	 * @param lista
	 * @return
	 */
	public static List<String> removeNull(List<String> lista) {
		Iterables.removeIf(lista, Predicates.isNull());
		return lista;
	}
	

}






















