package br.com.start.bo;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.ServicoOrdemServico;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class ServicoOrdemServicoBO implements Serializable, AppBO<ServicoOrdemServico> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<ServicoOrdemServico> query;

	@Inject
	private PersistenceUtils<ServicoOrdemServico> dao;

	@Override
	public void grava(ServicoOrdemServico servicoOrdemServico) {
		dao.save(servicoOrdemServico);
	}

	@Override
	public void remove(ServicoOrdemServico servicoOrdemServico) {
		dao.remove(servicoOrdemServico);
	}

	@Override
	public List<ServicoOrdemServico> all() {
		return query.all(ServicoOrdemServico.class);
	}

	@Override
	public List<ServicoOrdemServico> selected(String value) {
		return null; //query.recuperaItem(ServicoOrdemServico.class, value, "nome");
	}

	@Override
	public ServicoOrdemServico get(Long id) {
		return query.get(ServicoOrdemServico.class, id);
	}


}
