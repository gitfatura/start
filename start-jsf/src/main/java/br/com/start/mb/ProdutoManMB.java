package br.com.start.mb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.CategoriaEntity;
import br.com.start.entity.EstoqueEntity;
import br.com.start.entity.ProdutoEntity;
import br.com.start.facade.CategoriaFacade;
import br.com.start.facade.EstoqueFacade;
import br.com.start.facade.ICrudMB;
import br.com.start.facade.ProdutoFacade;

@ViewScoped
@Named
public class ProdutoManMB implements Serializable, ICrudMB {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ProdutoFacade produtoFacade;

	@Inject
	private CategoriaFacade categoriaFacade;

	@Inject
	private EstoqueFacade estoqueFacade;

	private List<CategoriaEntity> categorias;

	private List<EstoqueEntity> estoques;
	
	private Integer novaQuantidade;
	
	private String valorStr;

	@Inject
	private ProdutoEntity produto;

	@PostConstruct
	public void inicia() {
		recuperaProduto();
	}

	@Override
	public void grava() {
		if (produto == null) {
			FacesUtil.addErrorMessage("Erro ao registrar");
		} else {
			if (StringUtils.isNotEmpty(valorStr)) {
				produto.setValor(new BigDecimal(valorStr.trim().replace(".", "").replace(",", ".")));
				produto.setValorTotal(BigDecimal.valueOf(produto.getValor().doubleValue() * produto.getQuantidade())); 
			}
			produtoFacade.save(this.produto);
			valorStr = null;
			limpar();
			FacesUtil.addInfoMessage("Registro gravado com sucesso!");
		}
	}

	public void limpar() {
		produto = new ProdutoEntity();
	}
	
	public void entradaProduto() {
		if (novaQuantidade ==null || novaQuantidade ==0) {
			FacesUtil.addInfoMessageWarn("Informe a quantidade do produto");
		}else {
			produto.setQuantidade(novaQuantidade);
			produtoFacade.entradaProduto(produto);
		}
		
	}
	
	public void saidaProduto() {
		produtoFacade.saidaProduto(produto);
	}
	
	
	private void recuperaProduto() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			categorias = categoriaFacade.all();
			estoques = estoqueFacade.all();
			this.produto = produtoFacade.recuperaProduto(Long.valueOf(id));
			
			if (StringUtils.isEmpty(valorStr)) {
				valorStr = String.valueOf(produto.getValor());
			}
			
		} else {
			categorias = categoriaFacade.all();
			estoques = estoqueFacade.all();
		}
	}

	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	public List<CategoriaEntity> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaEntity> categorias) {
		this.categorias = categorias;
	}

	public List<EstoqueEntity> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<EstoqueEntity> estoques) {
		this.estoques = estoques;
	}

	public String getValorStr() {
		return valorStr;
	}

	public void setValorStr(String valorStr) {
		this.valorStr = valorStr;
	}

	public Integer getNovaQuantidade() {
		return novaQuantidade;
	}

	public void setNovaQuantidade(Integer novaQuantidade) {
		this.novaQuantidade = novaQuantidade;
	}
	
	


}
