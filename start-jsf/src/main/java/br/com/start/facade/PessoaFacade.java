package br.com.start.facade;

import java.util.List;

import br.com.start.entity.Pessoa;
import br.com.start.types.TipoPessoa;

public interface PessoaFacade {
	public void grava(Pessoa pessoa);
	public List<Pessoa> all();
	public void remove(Pessoa pessoa);
	public List<Pessoa> selected(String value);
	public List<Pessoa> recuperaPeloTipoPessoa(String valor, TipoPessoa tipoPessoa);
	public Pessoa get(Long id);
	
}
