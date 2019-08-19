package br.com.start.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class ProdutoConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	/**
	@Inject
	private ProdutoFacade produtoFacade;

	@Inject
	private ProdutoEntity produto;

	private String pesquisa;
	
	private BigDecimal valorTotal;

	private List<ProdutoEntity> produtos;
	
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

	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	public List<ProdutoEntity> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoEntity> produtos) {
		this.produtos = produtos;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	*/
	

}
