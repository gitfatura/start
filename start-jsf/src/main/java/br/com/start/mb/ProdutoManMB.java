package br.com.start.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.Produto;
import br.com.start.facade.ProdutoFacade;

@ViewScoped
@Named
public class ProdutoManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ProdutoFacade produtoFacade;

	@Inject
	private Produto produto;

	@PostConstruct
	public void inicia() {
		recuperaProduto();
	}

	public void grava() {
		produtoFacade.grava(produto);
		FacesUtil.addInfoMessage("Registro gravado com sucesso!");
		novaInstancia();
	}

	public void novaInstancia() {
		produto = new Produto();
	}

	private void recuperaProduto() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.produto = produtoFacade.recuperaProduto(Long.valueOf(id));
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
