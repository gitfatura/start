package br.com.start.bo;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.Avaria;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class AvariaBO implements Serializable, AppBO<Avaria> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<Avaria> query;

	@Inject
	private PersistenceUtils<Avaria> dao;

	@Override
	public void grava(Avaria avaria) {
		dao.save(avaria);
	}

	@Override
	public void remove(Avaria avaria) {
		dao.remove(avaria);
	}

	@Override
	public List<Avaria> all() {
		return query.all(Avaria.class);
	}

	@Override
	public List<Avaria> selected(String value) {
		return query.recuperaItem(Avaria.class, value, "descricao");
	}

	@Override
	public Avaria get(Long id) {
		return query.get(Avaria.class, id);
	}

}
