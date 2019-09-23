package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.PessoaBO;
import br.com.start.entity.Pessoa;
import br.com.start.facade.PessoaFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class PessoaImpl implements Serializable, PessoaFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private PessoaBO pessoaBO;

	@Transactional
	@Override
	public void grava(Pessoa pessoa) {
		pessoaBO.grava(pessoa);
	}

	@Transactional
	@Override
	public void remove(Pessoa pessoa) {
		pessoaBO.remove(pessoa);
	}

	@Override
	public List<Pessoa> all() {
		return pessoaBO.all();
	}

	@Override
	public List<Pessoa> selected(String value) {
		return pessoaBO.selected(value);
	}

	@Override
	public Pessoa get(Long id) {
		return pessoaBO.get(id);
	}

	@Override
	public List<Pessoa> recuperaPeloTipoPessoa(String valor, boolean ehFuncionario, boolean ehPessoaFisica, boolean ehPessoaJuridica) {
		return pessoaBO.recuperaPeloTipoPessoa(valor, ehFuncionario, ehPessoaFisica, ehPessoaJuridica);
	}

}
