package br.com.start.bo;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.Servico;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class ServicoBO implements Serializable, AppBO<Servico> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private PersistenceUtils<Servico> dao;

	@Inject
	private QueryUtils<Servico> query;

	@Override
	public void grava(Servico servico) {
		dao.save(servico);
	}

	@Override
	public void remove(Servico servico) {
		dao.remove(servico);
	}

	@Override
	public Servico get(Long id) {
		return query.get(Servico.class, id);
	}

	@Override
	public List<Servico> all() {
		return query.all(Servico.class);
	}

	@Override
	public List<Servico> selected(String value) {
		return query.recuperaItem(Servico.class, value, "descricao");
	}

	public Servico recuperaservico(Long id) {
		return query.get(Servico.class, id);
	}

}
