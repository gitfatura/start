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
			veiculoFacade.gravaVeiculo(veiculo);
			novaInstancia();
			FacesUtil.addInfoMessage("Registro gravado com sucesso!");
		} catch (Exception e) {
			if (e.getCause().getMessage().contains("ConstraintViolationException:")) {
				FacesUtil.addErrorMessageFatal("Placa " + veiculo.getPlaca() + " já existe.");
			}
		}
	}

	public List<Pessoa> completarPessoa(String nome) {
		return pessoaFacade.selected(nome);
	}
	
	public void pessoaSelecionada(SelectEvent event) {
		pessoa = (Pessoa) event.getObject();
	}

	public void recuperaPessoa() {
		pessoas = pessoaFacade.all();
	}

	public void novaInstancia() {
		veiculo = new Veiculo();
	}

	private void recuperaVeiculos() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.veiculo = veiculoFacade.get(Long.valueOf(id));
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
