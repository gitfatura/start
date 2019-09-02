package br.com.start.backup;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class FornecedorManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	/**
	@Inject
	private FornecedorFacade fornecedorFacade;

	@Inject
	private FornecedorEntity fornecedor;

	@PostConstruct
	public void start() {
		recuperaCarro();
	}

	@Override
	public void grava() {
		if (fornecedor == null) {
			FacesUtil.addErrorMessage("Erro ao registrar");
		} else {
			fornecedorFacade.save(fornecedor);
			novaInstancia();
			FacesUtil.addInfoMessage("Registro gravado com sucesso!");
		}
	}

	public void novaInstancia() {
		fornecedor = new FornecedorEntity();
	}

	private void recuperaCarro() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.fornecedor = fornecedorFacade.get(Long.valueOf(id));
		}
	}

	public FornecedorEntity getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(FornecedorEntity fornecedor) {
		this.fornecedor = fornecedor;
	}
*/
}
