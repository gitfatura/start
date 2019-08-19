package br.com.start.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class CategoriaManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	/**
	@Inject
	private CategoriaFacade categoriaFacade;

	@Inject
	private CategoriaEntity categoria;
	
	@PostConstruct
	public void inicia() {
		recuperaCategoria();	
	}
	
	@Override
	public void grava() {
		if (categoria == null) {
			FacesUtil.addErrorMessage("Erro ao registrar");
		} else {

			categoriaFacade.save(this.categoria);
			limpar();
			FacesUtil.addInfoMessage("Registro gravado com sucesso!");
		}
	}

	public void limpar() {
		categoria = new CategoriaEntity();
	}

	private void recuperaCategoria() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.categoria = categoriaFacade.get(Long.valueOf(id));
		}
	}

	public CategoriaFacade getCategoriaFacade() {
		return categoriaFacade;
	}

	public void setCategoriaFacade(CategoriaFacade categoriaFacade) {
		this.categoriaFacade = categoriaFacade;
	}

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}
*/
}
