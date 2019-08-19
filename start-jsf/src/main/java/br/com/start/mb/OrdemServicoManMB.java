package br.com.start.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.OrdemServico;
import br.com.start.entity.Pessoa;
import br.com.start.entity.Servico;
import br.com.start.entity.Veiculo;
import br.com.start.facade.OrdemServicoFacade;
import br.com.start.facade.PessoaFacade;
import br.com.start.facade.ServicoFacade;
import br.com.start.facade.VeiculoFacade;
import br.com.start.types.Finalizado;

@ViewScoped
@Named
public class OrdemServicoManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private OrdemServicoFacade ordemServicoFacade;
	@Inject
	private OrdemServico ordemServico;
	
	
	@Inject
	private VeiculoFacade veiculoFacade;
	@Inject
	private Veiculo veiculo;
	private List<Veiculo> veiculos;
	
	
	
	@Inject
	private ServicoFacade servicoFacade;
	@Inject
	private Servico servico;

	
	
	@Inject
	private PessoaFacade pessoaFacade;
	@Inject
	private Pessoa pessoa;
	private List<Pessoa> pessoas;

	
	
	
	private String valorStr;

	@PostConstruct
	public void start() {
		recuperaVeiculos();
		recuperaPessoa();
	}

	public void grava() {
		servicoFacade.grava(servico);
		novaInstancia();
		FacesUtil.addInfoMessage("Registro gravado com sucesso!");
	}

	public void novaInstancia() {
		servico = new Servico();
		valorStr = null;
	}

	private void recuperaPessoa() {
		pessoas = pessoaFacade.all();
	}
	
	private void recuperaVeiculos() {
		veiculos = veiculoFacade.all();
	}
	
	public Finalizado[] getFinalizado() {
		return Finalizado.values();
	}
	
	private void recuperaServico() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.servico = servicoFacade.get(Long.valueOf(id));
		}
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String getValorStr() {
		return valorStr;
	}

	public void setValorStr(String valorStr) {
		this.valorStr = valorStr;
	}

	 

}
