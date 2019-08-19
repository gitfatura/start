package br.com.start.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.Avaria;
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

	@Inject
	private Avaria avaria;

	private List<Avaria> avarias;

	private List<Pessoa> pessoas;

	@PostConstruct
	public void start() {
		recuperaPessoa();
		recuperaVeiculos();
		avarias = new ArrayList<Avaria>();
	}

	public void grava() {
		veiculo.setAvarias(avarias);
		veiculoFacade.grava(veiculo);
		novaInstancia();
		FacesUtil.addInfoMessage("Registro gravado com sucesso!");
	}

	public void recuperaPessoa() {
		pessoas = pessoaFacade.all();
	}

	public void novaInstancia() {
		veiculo = new Veiculo();
	}

	public void adicionaAvaria() {
		avarias.add(avaria);
		avaria = new Avaria();
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

	public Avaria getAvaria() {
		return avaria;
	}

	public void setAvaria(Avaria avaria) {
		this.avaria = avaria;
	}

	public List<Avaria> getAvarias() {
		return avarias;
	}

	public void setAvarias(List<Avaria> avarias) {
		this.avarias = avarias;
	}

}
