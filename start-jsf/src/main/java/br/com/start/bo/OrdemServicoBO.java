package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.OrdemServico;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class OrdemServicoBO implements Serializable, AppBO<OrdemServico> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<OrdemServico> query;

	@Inject
	private PersistenceUtils<OrdemServico> dao;

	@Override
	public void grava(OrdemServico ordemServico) {
		dao.save(ordemServico);
	}

	@Override
	public void remove(OrdemServico ordemServico) {
		dao.remove(ordemServico);
	}

	@Override
	public List<OrdemServico> all() {
		return query.all(OrdemServico.class);
	}

	@Override
	public List<OrdemServico> selected(String value) {
		return query.recuperaItem(OrdemServico.class, value, "nome");
	}

	@Override
	public OrdemServico get(Long id) {
		return query.get(OrdemServico.class, id);
	}

}
