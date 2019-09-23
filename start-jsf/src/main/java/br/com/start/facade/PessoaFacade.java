package br.com.start.facade;

import java.util.List;

import br.com.start.entity.Pessoa;

public interface PessoaFacade {
	public void grava(Pessoa pessoa);
	public List<Pessoa> all();
	public void remove(Pessoa pessoa);
	public List<Pessoa> selected(String value);
	public List<Pessoa> recuperaPeloTipoPessoa(String valor, boolean ehFuncionario, boolean ehPessoaFisica, boolean ehPessoaJuridica);
	public Pessoa get(Long id);
	
}
