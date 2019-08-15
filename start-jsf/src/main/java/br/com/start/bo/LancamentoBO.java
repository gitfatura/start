package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.LancamentoEntity;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class LancamentoBO implements Serializable, AppBO<LancamentoEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<LancamentoEntity> query;
		
	@Inject
	private PersistenceUtils<LancamentoEntity> dao;

	@Override
	public void save(LancamentoEntity lancamento) {
		dao.save(lancamento);
	}

	@Override
	public void remove(LancamentoEntity lancamento) {
		dao.remove(lancamento);
	}

	@Override
	public List<LancamentoEntity> all() {
		return query.all(LancamentoEntity.class);
	}

	@Override
	public List<LancamentoEntity> selected(String value) {
		return query.recuperaItem(LancamentoEntity.class, value, "titulo");
	}

	@Override
	public LancamentoEntity get(Long idLancamento) {
		return query.get(LancamentoEntity.class, idLancamento);
	}

}
