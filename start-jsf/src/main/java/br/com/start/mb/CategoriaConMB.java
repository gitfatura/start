package br.com.start.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.CategoriaEntity;
import br.com.start.facade.CategoriaFacade;

@ViewScoped
@Named
public class CategoriaConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private CategoriaFacade categoriaFacade;

	@Inject
	private CategoriaEntity categoria;

	private List<CategoriaEntity> categorias;

	private String pesquisa;

	@PostConstruct
	public void inicia() {
		selected();
	}

	public void selected() {
		if (StringUtils.isNotEmpty(pesquisa)) {
			categorias = new ArrayList<>();
			categorias = categoriaFacade.selected(pesquisa);

		} else {
			categorias = categoriaFacade.all();
		}

	}

	public void remove() {
		try {
			categoriaFacade.remove(categoria);
			FacesUtil.addInfoMessage("Registro removido com sucesso!");
			categorias = categoriaFacade.all();
		} catch (Exception e) {
			if (e.getMessage().contains("ConstraintViolationException")) {
				FacesUtil.addInfoMessage("Não pode remover a categoria: "+categoria.getDescricao()+", porque está sendo usada por produto");	
			}
		}
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	public List<CategoriaEntity> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaEntity> categorias) {
		this.categorias = categorias;
	}

}
