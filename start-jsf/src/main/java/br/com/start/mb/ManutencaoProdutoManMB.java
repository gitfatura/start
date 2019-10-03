package br.com.start.mb;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.Produto;
import br.com.start.facade.ProdutoFacade;
import br.com.start.types.EntradaSaidaProduto;

@ViewScoped
@Named
public class ManutencaoProdutoManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ProdutoFacade produtoFacade;

	@Inject
	private Produto produto;

	private String entradaSaidaProdutoStr;

	private String codigoStr;

	public void grava() {
		produtoFacade.entradaSaidaProduto(produto, EntradaSaidaProduto.valueOf(entradaSaidaProdutoStr));
		FacesUtil.addInfoMessage("Registro gravado com sucesso!");
		codigoStr = null;
		entradaSaidaProdutoStr = null;
		produto = new Produto();
	}
	
	public List<Produto> completarProduto(String descricao) {
		return produtoFacade.selected(descricao);
	}
	
	public void produtoSelecionado(SelectEvent event) {
		produto = (Produto) event.getObject();
	}

	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);
		PrimeFaces.current().dialog().openDynamic("produtoselecao", opcoes, null);
	}
	
	public void selecionar(Produto produto) {
		PrimeFaces.current().dialog().closeDynamic(produto);
	}
	
	public EntradaSaidaProduto[] getEntradaSaidaProduto() {
		return EntradaSaidaProduto.values();
	}

	public void pesquisaProduto() {
		produto = produtoFacade.get(Long.valueOf(codigoStr));
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getEntradaSaidaProdutoStr() {
		return entradaSaidaProdutoStr;
	}

	public void setEntradaSaidaProdutoStr(String entradaSaidaProdutoStr) {
		this.entradaSaidaProdutoStr = entradaSaidaProdutoStr;
	}

	public String getCodigoStr() {
		return codigoStr;
	}

	public void setCodigoStr(String codigoStr) {
		this.codigoStr = codigoStr;
	}

}
