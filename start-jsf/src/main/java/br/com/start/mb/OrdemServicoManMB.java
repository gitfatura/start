package br.com.start.mb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.OrdemServico;
import br.com.start.entity.Servico;
import br.com.start.entity.Veiculo;
import br.com.start.facade.OrdemServicoFacade;
import br.com.start.facade.ServicoFacade;
import br.com.start.facade.VeiculoFacade;

@ViewScoped
@Named
public class OrdemServicoManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private Veiculo veiculo;
	
	@Inject
	private Servico servico;

	@Inject
	private OrdemServicoFacade ordemServicoFacade;

	@Inject
	private OrdemServico ordemServico;

	@Inject
	private VeiculoFacade veiculoFacade;

	@Inject
	private ServicoFacade servicoFacade;

	private String filtroPlaca;
	private String status;

	private List<Veiculo> veiculos;
	private List<Servico> servicos;
	private List<Servico> servicosFiltrados;
	private BigDecimal valorServicos;
	
	@PostConstruct
	public void start() {
		
	}
	
	public void grava() {
		ordemServico.setVeiculo(veiculo);
		ordemServicoFacade.gravaServicos(servicosFiltrados);
		ordemServicoFacade.grava(ordemServico);
		novaInstancia();
		FacesUtil.addInfoMessage("Registro gravado com sucesso!");
	}
	
	
	private void caculaServico() {
		if(servicosFiltrados !=null && servicosFiltrados.size()>0) {
			valorServicos = BigDecimal.ZERO;
			for(Servico umServico : servicosFiltrados) {
				valorServicos = valorServicos.add(umServico.getValor());
			}
		}
	}

	
	public void adicionaServico() {
		if (servico !=null) {
			if(servicosFiltrados ==null) {
				servicosFiltrados = new ArrayList<Servico>();
			}
			servico.setOrdemServico(ordemServico);
			servicosFiltrados.add(servico);
		}
		
		servico = new Servico();
		
		caculaServico();
	}

	public void removeServico() {
		servicosFiltrados.remove(servico);
		caculaServico();
	}
	
	public void recuperaVeiculo() {
		if (StringUtils.isNotBlank(filtroPlaca)) {
			try {
				veiculo = ordemServicoFacade.recuperaVeiculoPelaPlaca(filtroPlaca);
			} catch (Exception e) {
				if (e.getMessage().contains("No entity found for query")) {
					FacesUtil.addInfoMessageWarn("Nenhum veículo encontrado.");
				}
			}
		}
	}

	public void abrirDialogoVeiculo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 500);
		PrimeFaces.current().dialog().openDynamic("veiculoselecao", opcoes, null);
	}

	public void abrirDialogoServico() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 500);
		PrimeFaces.current().dialog().openDynamic("servicoselecao", opcoes, null);
	}

	public List<Veiculo> completarVeiculo(String modelo) {
		return veiculoFacade.selected(modelo);
	}

	public List<Servico> completarServicos(String descricao) {
		return servicoFacade.selected(descricao);
	}

	public void veiculoSelecionado(SelectEvent event) {
		veiculo = (Veiculo) event.getObject();
	}

	public void servicoSelecionado(SelectEvent event) {
		servico = (Servico) event.getObject();
	}

	public void selecionar(Veiculo veiculo) {
		PrimeFaces.current().dialog().closeDynamic(veiculo);
	}

	public void selecionarServico(Servico servico) {
		PrimeFaces.current().dialog().closeDynamic(servico);
	}
	
	public String montaFiltros() {
		
		StringBuilder filtros = new StringBuilder();
		filtros.append("Filtros: ");
		
		if (StringUtils.isNotBlank(filtroPlaca)) {
			filtros.append(" Placa: ").append(filtroPlaca);
		}
		if (veiculo != null && StringUtils.isNotBlank(veiculo.getModelo())) {
			filtros.append(" Veículo: ").append(filtroPlaca);
		}
		if (servico != null && StringUtils.isNotBlank(servico.getDescricao())) {
			filtros.append(" Serviço: ").append(servico.getDescricao());
		}

		if (StringUtils.isNotBlank(status)) {
			filtros.append(" Status: ").append(status);
		}

		return filtros.toString();
	}
	
	public void novaInstancia() {
		ordemServico = new OrdemServico();
		filtroPlaca = null;
		status = null;
		veiculos = new ArrayList<Veiculo>();
		servicos = new ArrayList<Servico>();
		servicosFiltrados = new ArrayList<Servico>();
		valorServicos = null;
		PrimeFaces.current().ajax().update("frm:filtros:veiculo,frm:filtros:veiculo_input");
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


	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public String getFiltroPlaca() {
		return filtroPlaca;
	}

	public void setFiltroPlaca(String filtroPlaca) {
		this.filtroPlaca = filtroPlaca;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Servico> getServicosFiltrados() {
		return servicosFiltrados;
	}

	public void setServicosFiltrados(List<Servico> servicosFiltrados) {
		this.servicosFiltrados = servicosFiltrados;
	}

	public BigDecimal getValorServicos() {
		return valorServicos;
	}

	public void setValorServicos(BigDecimal valorServicos) {
		this.valorServicos = valorServicos;
	}
	
}
