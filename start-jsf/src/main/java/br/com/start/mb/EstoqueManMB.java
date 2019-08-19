package br.com.start.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class EstoqueManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	/**
	@Inject
	private EstoqueFacade estoqueFacade;

	@Inject
	private EstoqueEntity estoque;

	@PostConstruct
	public void inicia() {
		recuperaEstoque();
	}

	@Override
	public void grava() {
		if (estoque == null) {
			FacesUtil.addErrorMessage("Erro ao registrar");
		} else {

			estoqueFacade.save(this.estoque);
			limpar();
			FacesUtil.addInfoMessage("Registro gravado com sucesso!");
		}
	}

	public void limpar() {
		estoque = new EstoqueEntity();
	}

	private void recuperaEstoque() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.estoque = estoqueFacade.get(Long.valueOf(id));
		}
	}

	public EstoqueEntity getEstoque() {
		return estoque;
	}

	public void setEstoque(EstoqueEntity estoque) {
		this.estoque = estoque;
	}
*/
}
