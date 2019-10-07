package br.com.start.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.SelectEvent;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.Pessoa;
import br.com.start.entity.Veiculo;
import br.com.start.facade.PessoaFacade;
import br.com.start.facade.VeiculoFacade;

@ViewScoped
@Named
public class VeiculoManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private VeiculoFacade veiculoFacade;

	@Inject
	private PessoaFacade pessoaFacade;

	@Inject
	private Veiculo veiculo;

	private List<Pessoa> pessoas;

	@Inject
	private Pessoa pessoa;

	@PostConstruct
	public void start() {
		recuperaPessoa();
		recuperaVeiculos();
	}

	public void grava() {
		try {
			if(!validaVeiculo(veiculo)) {
				veiculoFacade.gravaVeiculo(veiculo);
				pessoa = new Pessoa();
				novaInstancia();
				FacesUtil.addInfoMessage("Registro gravado com sucesso!");
			}else {
				FacesUtil.addErrorMessageFatal("Placa " + veiculo.getPlaca() + " já existe.");
			}
		} catch (Exception e) {
			FacesUtil.addErrorMessageFatal("Ocorreu um erro interno: "+ e.getMessage());
		}
	}

	private boolean validaVeiculo(Veiculo veiculo) {
		return veiculoFacade.existeVeiculo(StringUtils.isNotBlank(veiculo.getPlaca()) ? veiculo.getPlaca() :null);
	}

	public List<Pessoa> completarPessoa(String nome) {
		return pessoaFacade.selected(nome);
	}
	
	public void pessoaSelecionada(SelectEvent event) {
		pessoa = (Pessoa) event.getObject();
	}
	
	public void veiculoSelecionada(SelectEvent event) {
		veiculo = (Veiculo) event.getObject();
	}
	
	
	public void recuperaPessoa() {
		pessoas = pessoaFacade.all();
	}

	public void novaInstancia() {
		veiculo = new Veiculo();
		pessoa = new Pessoa();
	}

	private void recuperaVeiculos() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.veiculo = veiculoFacade.get(Long.valueOf(id));
			pessoa = veiculo.getPessoa();
		}
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
