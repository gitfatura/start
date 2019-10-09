package br.com.start.facade;

import java.util.List;

import br.com.start.entity.Pessoa;
import br.com.start.entity.Usuario;

public interface UsuarioFacade {
	
	public Usuario logar(Usuario usuario);
	
	public List<Pessoa> selected(String value);
	
	public List<Pessoa> recuperaFuncionarios(String valorPesquisa); 
	
	

}
