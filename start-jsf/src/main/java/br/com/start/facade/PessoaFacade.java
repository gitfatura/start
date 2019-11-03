package br.com.start.facade;

import java.util.List;

import br.com.start.entity.Pessoa;

public interface PessoaFacade {
	public void grava(Pessoa pessoa);
	public List<Pessoa> all();
	public void remove(Pessoa pessoa);
	public List<Pessoa> selected(String value);
	public List<Pessoa> recuperaCliente(String valor);
	public Pessoa get(Long id);
	public boolean existePessoa(String cpf, String cnpj);
	public List<Pessoa> recuperaFuncionarios(String valor);
	
}
