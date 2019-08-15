package br.com.start.facade;

import java.util.List;

import br.com.start.entity.EstoqueEntity;

public interface EstoqueFacade {
	
	public void save(EstoqueEntity estoque);

	public List<EstoqueEntity> all();

	public void remove(EstoqueEntity estoque);
	
	public List<EstoqueEntity> selected(String value);

	public EstoqueEntity get(Long id);
	
	
}
