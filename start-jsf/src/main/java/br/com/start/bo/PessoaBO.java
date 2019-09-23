package br.com.start.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.start.dao.PersistenceUtils;
import br.com.start.dao.QueryUtils;
import br.com.start.entity.Pessoa;
import br.com.start.facade.AppBO;

@ApplicationScoped
public class PessoaBO implements Serializable, AppBO<Pessoa> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<Pessoa> query;

	@Inject
	private PersistenceUtils<Pessoa> dao;

	@Override
	public void grava(Pessoa pessoa) {
		dao.save(pessoa);
	}

	@Override
	public void remove(Pessoa pessoa) {
		dao.remove(pessoa);
	}

	@Override
	public List<Pessoa> all() {
		return query.all(Pessoa.class);
	}

	@Override
	public List<Pessoa> selected(String value) {
		if (StringUtils.isNumeric(value)) {
			return query.recuperaValores(Pessoa.class, value, "id");
		}
		return query.recuperaValores(Pessoa.class, value, "nome");
	}

	@Override
	public Pessoa get(Long id) {
		return query.get(Pessoa.class, id);
	}

	public List<Pessoa> recuperaPeloTipoPessoa(String valor, boolean ehFuncionario, boolean ehPessoaFisica, boolean ehPessoaJuridica) {
		return query.recuperaPessoa(valor, ehFuncionario, ehPessoaFisica, ehPessoaJuridica);
	}

}
