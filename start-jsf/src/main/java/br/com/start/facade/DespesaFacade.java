package br.com.start.facade;

import java.util.List;

import br.com.start.entity.DespesaEntity;

public interface DespesaFacade {
	
	public void save(DespesaEntity despesa);

	public List<DespesaEntity> all();

	public void remove(DespesaEntity despesa);
	
	public List<DespesaEntity> selected(String value);

	public DespesaEntity get(Long id);
	
	
	
}
