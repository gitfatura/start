package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.VeiculoBO;
import br.com.start.entity.Veiculo;
import br.com.start.facade.VeiculoFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class VeiculoImpl implements Serializable, VeiculoFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private VeiculoBO veiculoBO;

	@Transactional
	@Override
	public void grava(Veiculo veiculo) {
		veiculoBO.grava(veiculo);
	}

	@Transactional
	@Override
	public void remove(Veiculo veiculo) {
		veiculoBO.remove(veiculo);
	}

	@Override
	public List<Veiculo> all() {
		return veiculoBO.all();
	}

	@Override
	public List<Veiculo> selected(String value) {
		return veiculoBO.selected(value);
	}

	@Override
	public Veiculo get(Long id) {
		return veiculoBO.get(id);
	}

	@Transactional
	@Override
	public void gravaVeiculo(Veiculo veiculo) {
		veiculoBO.grava(veiculo);
	}
	
	public List<Veiculo> recuperaVeiculos(String pessoaNome) {
		return veiculoBO.recuperaVeiculos(pessoaNome);
	}
	
	public boolean existeVeiculo(String placa) {
		return veiculoBO.existeRegistro(placa);
	}

}
