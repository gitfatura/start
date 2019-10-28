package br.com.start.mb;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import br.com.start.entity.OrdemServico;
import br.com.start.entity.Pessoa;
import br.com.start.entity.ServicoOrdemServico;
import br.com.start.entity.Veiculo;
import br.com.start.facade.OrdemServicoFacade;
import br.com.start.facade.PessoaFacade;

@ViewScoped
@Named
public class OrdemServicoConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private OrdemServicoFacade ordemServicoFacade;

	@Inject
	private ServicoOrdemServico servicoSelecionado;

	@Inject
	private PessoaFacade pessoaFacade;

	@Inject
	private Pessoa pessoa;

	private List<ServicoOrdemServico> servicosSelecionado;

	private List<OrdemServico> ordemServicos;
	
	private List<Pessoa> pessoasFiltradas;

	private String pesquisa;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	@PostConstruct
	public void start() {
		recuperaOrdemServico();
		pessoasSelecionadas();
	}
	
	public void pesquisarOrdemServicos() {
		ordemServicos = ordemServicoFacade.recuperaOrdemServicos(pessoa !=null ? pessoa.getId() :null, dataInicio, dataFim);
	}
	
	public void recuperaOrdemServico() {
		ordemServicos = ordemServicoFacade.all();
	}
	
	public void selecionar(Pessoa pessoa) {
		PrimeFaces.current().dialog().closeDynamic(pessoa);
	}
	
	public void pessoasSelecionadas() {
		pessoasFiltradas = pessoaFacade.selected(pesquisa);
	}
	
	public void pessoaSelecionada(SelectEvent event) {
		pessoa = (Pessoa) event.getObject();
	}
	
	public List<Pessoa> completarPessoa(String nome) {
		return pessoaFacade.selected(nome);
	}
	
	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);
		PrimeFaces.current().dialog().openDynamic("pessoaselecaoordemservico", opcoes, null);
	}
	
	public void servicoSelected(OrdemServico ordemServico) {
		servicosSelecionado = ordemServicoFacade.recuperaServicoOrdemServicos(ordemServico.getId());
	}

	public List<ServicoOrdemServico> getServicosSelecionado() {
		return servicosSelecionado;
	}

	public void setServicosSelecionado(List<ServicoOrdemServico> servicosSelecionado) {
		this.servicosSelecionado = servicosSelecionado;
	}

	public List<OrdemServico> getOrdemServicos() {
		return ordemServicos;
	}

	public void setOrdemServicos(List<OrdemServico> ordemServicos) {
		this.ordemServicos = ordemServicos;
	}

	public ServicoOrdemServico getServicoSelecionado() {
		return servicoSelecionado;
	}

	public void setServicoSelecionado(ServicoOrdemServico servicoSelecionado) {
		this.servicoSelecionado = servicoSelecionado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
