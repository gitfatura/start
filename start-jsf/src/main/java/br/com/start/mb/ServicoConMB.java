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
import br.com.start.entity.Servico;
import br.com.start.facade.ServicoFacade;

@ViewScoped
@Named
public class ServicoConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ServicoFacade servicoFacade;

	@Inject
	private Servico servico;

	private String pesquisa;

	private List<Servico> servicos;

	@PostConstruct
	public void start() {
		recuperaServicos();
	}

	public void recuperaServicos() {
		servicos = servicoFacade.recuperaServicos(pesquisa);
	}
	
	public void servicosSelecionados() {
		servicos = servicoFacade.recuperaServicos(pesquisa);
	}

	public void remove() {
		servicoFacade.remove(servico);
		FacesUtil.addInfoMessage("Registro removido com sucesso!");
		recuperaServicos();
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
}
