package br.com.start.facade;

import java.util.List;

import br.com.start.entity.Servico;

public interface ServicoFacade {
	public void grava(Servico servico);
	public List<Servico> all();
	public void remove(Servico servico);
	public Servico get(Long id);
	public List<Servico> recuperaServicos(String descricao);
	public boolean existeServico(String codigo);
	public List<Servico> selected(String value);
}
