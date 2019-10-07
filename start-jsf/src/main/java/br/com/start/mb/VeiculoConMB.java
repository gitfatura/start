package br.com.start.mb;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.Pessoa;
import br.com.start.entity.Veiculo;
import br.com.start.facade.PessoaFacade;
import br.com.start.facade.VeiculoFacade;

@ViewScoped
@Named
public class VeiculoConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private VeiculoFacade veiculoFacade;

	@Inject
	private PessoaFacade pessoaFacade;

	@Inject
	private Veiculo veiculo;

	private List<Pessoa> pessoas;

	private List<Veiculo> veiculos;

	private String pesquisa;

	private String placaSelecionada;

	private List<Pessoa> pessoasFiltradas;

	private List<Veiculo> veiculosFiltrados;

	@PostConstruct
	public void start() {
		recuperaVeiculosSelecionado();
	}

	public void grava() {
		veiculoFacade.gravaVeiculo(veiculo);
		novaInstancia();
		FacesUtil.addInfoMessage("Registro gravado com sucesso!");
	}

	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);
		PrimeFaces.current().dialog().openDynamic("veiculoselecao", opcoes, null);
	}

	public void pessoasSelecionadas() {
		pessoasFiltradas = pessoaFacade.selected(pesquisa);
	}
	
	public void veiculosSelecionados() {
		veiculosFiltrados = veiculoFacade.selected(pesquisa);
	}
	
	public void selecionar(Pessoa pessoa) {
		PrimeFaces.current().dialog().closeDynamic(pessoa);
	}

	public void remove() {
		veiculoFacade.remove(veiculo);
		recuperaVeiculosSelecionado();
	}

	public void recuperaPessoa() {
		pessoas = pessoaFacade.all();
	}

	public void novaInstancia() {
		veiculo = new Veiculo();
	}

	public void recuperaVeiculosSelecionado() {
		veiculos = veiculoFacade.recuperaVeiculos(pesquisa);
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

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public String getPlacaSelecionada() {
		return placaSelecionada;
	}

	public void setPlacaSelecionada(String placaSelecionada) {
		this.placaSelecionada = placaSelecionada;
	}

	public List<Pessoa> getPessoasFiltradas() {
		return pessoasFiltradas;
	}

	public void setPessoasFiltradas(List<Pessoa> pessoasFiltradas) {
		this.pessoasFiltradas = pessoasFiltradas;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public List<Veiculo> getVeiculosFiltrados() {
		return veiculosFiltrados;
	}

	public void setVeiculosFiltrados(List<Veiculo> veiculosFiltrados) {
		this.veiculosFiltrados = veiculosFiltrados;
	}

}
