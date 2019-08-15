package br.com.start.facade;

import java.util.List;

import br.com.start.entity.LancamentoEntity;

public interface LancamentoFacade {
	
	public void save(LancamentoEntity lancamento);

	public List<LancamentoEntity> all();

	public void remove(LancamentoEntity lancamento);
	
	public List<LancamentoEntity> selected(String value);

	public LancamentoEntity get(Long id);
	
	
}
