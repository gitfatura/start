package br.com.start.mb;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.start.entity.OrdemServico;
import br.com.start.entity.ServicoOrdemServico;
import br.com.start.facade.OrdemServicoFacade;

@ViewScoped
@Named
public class OrdemServicoConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private OrdemServicoFacade ordemServicoFacade;
	
	@Inject
	private ServicoOrdemServico servicoSelecionado;

	private List<ServicoOrdemServico> servicosSelecionado;
	
	private List<OrdemServico> ordemServicos;

	@PostConstruct
	public void start() {
		recuperaOrdemServico();
	}

	public void recuperaOrdemServico() {
		ordemServicos = ordemServicoFacade.all();
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

}
