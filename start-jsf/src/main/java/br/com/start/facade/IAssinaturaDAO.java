package br.com.start.facade;

import java.util.Date;
import java.util.List;

public interface IAssinaturaDAO<T> {
	public void grava(T t);
	public void update(T t);
	public void remove(T t);
	public T buscaPorId(Class<T> classe, Long id);
	public List<T> getAll(Class<T> classe);
	public List<T> recuperaItensOrdenado(Class<T> classe, String parametroOrdenado);
	public List<T> recuperaItemOrdenadoDescendente(Class<T> classe,String value,String nomeColuna);
	public List<T> recuperaItem(Class<T> classe,String valorARecuperar, String parametro);
	public List<T> recuperaPorData(Class<T> classe,Date inicio, Date fim, String nomeColuna);
}
