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
import br.com.start.entity.EstoqueEntity;
import br.com.start.facade.EstoqueFacade;

@ViewScoped
@Named
public class EstoqueConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private EstoqueFacade estoqueFacade;

	@Inject
	private EstoqueEntity estoque;

	private List<EstoqueEntity> estoques;

	private String pesquisa;

	@PostConstruct
	public void inicia() {
		selected();
	}

	public void selected() {
		if (StringUtils.isNotEmpty(pesquisa)) {
			estoques = new ArrayList<>();
			estoques = estoqueFacade.selected(pesquisa);

		} else {
			estoques = estoqueFacade.all();
		}

	}

	public void remove() {
		estoqueFacade.remove(estoque);
		FacesUtil.addInfoMessage("Registro removido com sucesso!");
		estoques = estoqueFacade.all();
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public EstoqueEntity getEstoque() {
		return estoque;
	}

	public void setEstoque(EstoqueEntity estoque) {
		this.estoque = estoque;
	}

	public List<EstoqueEntity> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<EstoqueEntity> estoques) {
		this.estoques = estoques;
	}

}
