package br.com.start.backup;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class FornecedorConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	/**
	@Inject
	private FornecedorFacade fornecedorFacade;

	@Inject
	private FornecedorEntity fornecedor;

	private String pesquisa;

	private List<FornecedorEntity> fornecedores;

	@PostConstruct
	public void start() {
		recuperaFornecedores();
	}

	public void recuperaAgendasSelecionada() {
		if (StringUtils.isNotEmpty(pesquisa)) {
			fornecedores = new ArrayList<>();
			fornecedores = fornecedorFacade.selected(pesquisa);
		} else {
			fornecedores = fornecedorFacade.all();
		}

	}

	public void remove() {
		fornecedorFacade.remove(fornecedor);
		FacesUtil.addInfoMessage("Registro removido com sucesso!");
		recuperaFornecedores();
	}

	private void recuperaFornecedores() {
		fornecedores = fornecedorFacade.all();
	}

	public FornecedorEntity getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(FornecedorEntity fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<FornecedorEntity> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<FornecedorEntity> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
*/
}
