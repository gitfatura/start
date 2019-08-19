package br.com.start.facade;

import java.util.List;

import br.com.start.entity.Veiculo;

public interface VeiculoFacade {
	public void grava(Veiculo veiculo);
	public List<Veiculo> all();
	public void remove(Veiculo veiculo);
	public List<Veiculo> selected(String value);
	public Veiculo get(Long id);
}
