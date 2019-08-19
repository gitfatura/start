package br.com.start.bo;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.ContaPagarReceber;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class ContaPagarBO implements Serializable, AppBO<ContaPagarReceber> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<ContaPagarReceber> query;

	@Inject
	private PersistenceUtils<ContaPagarReceber> dao;

	@Override
	public void grava(ContaPagarReceber contaPagarReceber) {
		dao.save(contaPagarReceber);
	}

	@Override
	public void remove(ContaPagarReceber contaPagarReceber) {
		dao.remove(contaPagarReceber);
	}

	@Override
	public List<ContaPagarReceber> all() {
		return query.all(ContaPagarReceber.class);
	}

	@Override
	public List<ContaPagarReceber> selected(String value) {
		return query.recuperaItem(ContaPagarReceber.class, value, "descricao");
	}

	@Override
	public ContaPagarReceber get(Long id) {
		return query.get(ContaPagarReceber.class, id);
	}

}
