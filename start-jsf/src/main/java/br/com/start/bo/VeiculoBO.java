package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.as.VeiculoAS;
import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.Avaria;
import br.com.start.entity.Veiculo;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class VeiculoBO implements Serializable, AppBO<Veiculo> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<Veiculo> query;
		
	@Inject
	private PersistenceUtils<Veiculo> dao;
	
	@Inject
	private VeiculoAS veiculoAS;
	
	
	@Override
	public void grava(Veiculo veiculo) {
		dao.save(veiculo);
	}

	public void gravaVeiculo(Veiculo veiculo, List<Avaria> avarias) {
		veiculoAS.gravaVeiculo(veiculo, avarias);
	}
	
	@Override
	public void remove(Veiculo veiculo) {
		dao.remove(veiculo);
	}

	@Override
	public List<Veiculo> all() {
		return query.all(Veiculo.class);
	}

	@Override
	public List<Veiculo> selected(String value) {
		return query.recuperaItem(Veiculo.class, value, "nome");
	}

	@Override
	public Veiculo get(Long id) {
		return query.get(Veiculo.class, id);
	}

}
