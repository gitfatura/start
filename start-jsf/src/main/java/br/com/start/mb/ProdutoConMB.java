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
import br.com.start.entity.Produto;
import br.com.start.facade.ProdutoFacade;

@ViewScoped
@Named
public class ProdutoConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ProdutoFacade produtoFacade;

	@Inject
	private Produto produto;

	private String pesquisa;

	private List<Produto> produtos;

	@PostConstruct
	public void inicia() {
		selected();
	}

	public void selected() {
		if (StringUtils.isNotEmpty(pesquisa)) {
			produtos = new ArrayList<>();
			produtos = produtoFacade.selected(pesquisa);

		} else {
			produtos = produtoFacade.all();
		}

	}

	public void remove() {
		produtoFacade.remove(produto);
		FacesUtil.addInfoMessage("Registro removido com sucesso!");
		produtos = produtoFacade.all();
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
