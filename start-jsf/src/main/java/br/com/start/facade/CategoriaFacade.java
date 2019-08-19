package br.com.start.facade;

import java.util.List;

import br.com.start.entity.Categoria;

public interface CategoriaFacade {
	public void grava(Categoria categoria);
	public List<Categoria> all();
	public void remove(Categoria categoria);
	public List<Categoria> selected(String value);
	public Categoria get(Long id);
}
