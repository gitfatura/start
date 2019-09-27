package br.com.start.mb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;

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
	private static final DecimalFormat df = new DecimalFormat("#,##0.00");

	private String filtroPlaca;
	
	@Inject
	private Veiculo veiculo;

	
	@Inject
	private OrdemServicoFacade ordemServicoFacade;

	@Inject
	private OrdemServico ordemServico;

	@Inject
	private VeiculoFacade veiculoFacade;

	
	private List<Veiculo> veiculos;

	@Inject
	private ServicoFacade servicoFacade;

	@Inject
	private PessoaFacade pessoaFacade;

	@Inject
	private Pessoa pessoa;

	private List<Pessoa> pessoas;

	private String valorStr;

	private DualListModel<String> cities;

	@Inject
	private Servico servico;

	private DualListModel<String> dservicos;
	private List<Servico> servicos;

	private List<String> servicoSource = new ArrayList<>();
	private List<String> servicoTarget = new ArrayList<>();
	private BigDecimal valorServicos;

	@PostConstruct
	public void start() {
		recuperaVeiculos();
		recuperaPessoa();
		carregaServicos();

	}

	public void atualiza() {
		System.out.println("ddddd");
	}

	public void grava() {
		ordemServicoFacade.grava(ordemServico);
		novaInstancia();
		FacesUtil.addInfoMessage("Registro gravado com sucesso!");
	}

	public void novaInstancia() {
		ordemServico = new OrdemServico();
		valorStr = null;
	}

	private void recuperaPessoa() {
		pessoas = pessoaFacade.all();
	}

	public void caculaServico() {
		List<String> ldescricao = dservicos.getTarget();
		valorServicos = BigDecimal.ZERO;
		for (String umaDescricao : ldescricao) {
			for (Servico umServico : servicos) {
				String servicoDescricao = umServico.getDescricao() + " - R$" + df.format(umServico.getValor());
				if (umaDescricao.equals(servicoDescricao)) {
					valorServicos = valorServicos.add(umServico.getValor());
				}
			}
		}
	}
	
	

	private void carregaServicos() {
		servicos = servicoFacade.all();
		servicoSource = new ArrayList<>();
		servicoTarget = new ArrayList<>();

		for (Servico umServico : servicos) {
			servicoSource.add(umServico.getDescricao() + " - R$" + df.format(umServico.getValor()));
		}
		dservicos = new DualListModel<String>(servicoSource, servicoTarget);
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

	public String montaFiltros() {
		StringBuilder filtros = new StringBuilder();
		filtros.append("Filtros: ");
		if (StringUtils.isNotBlank(filtroPlaca)) {
			filtros.append(" Placa: ").append(filtroPlaca);
		}
		if (veiculo !=null && StringUtils.isNotBlank(veiculo.getModelo())) {
			filtros.append(" Veículo: ").append(filtroPlaca);
		}
		return filtros.toString();
	}
	
	public void abrirDialogoVeiculo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 500);
		PrimeFaces.current().dialog().openDynamic("veiculoselecao", opcoes, null);
	}
	
	public List<Veiculo> completarVeiculo(String modelo) {
		return veiculoFacade.selected(modelo);
	}
	
	public void veiculoSelecionado(SelectEvent event) {
		veiculo = (Veiculo) event.getObject();
	}
	
	
	public void selecionar(Veiculo veiculo) {
		PrimeFaces.current().dialog().closeDynamic(veiculo);
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

	public DualListModel<String> getCities() {
		return cities;
	}

	public void setCities(DualListModel<String> cities) {
		this.cities = cities;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public List<String> getServicoSource() {
		return servicoSource;
	}

	public void setServicoSource(List<String> servicoSource) {
		this.servicoSource = servicoSource;
	}

	public List<String> getServicoTarget() {
		return servicoTarget;
	}

	public void setServicoTarget(List<String> servicoTarget) {
		this.servicoTarget = servicoTarget;
	}

	public DualListModel<String> getDservicos() {
		return dservicos;
	}

	public void setDservicos(DualListModel<String> dservicos) {
		this.dservicos = dservicos;
	}

	public BigDecimal getValorServicos() {
		return valorServicos;
	}

	public void setValorServicos(BigDecimal valorServicos) {
		this.valorServicos = valorServicos;
	}

	public String getFiltroPlaca() {
		return filtroPlaca;
	}

	public void setFiltroPlaca(String filtroPlaca) {
		this.filtroPlaca = filtroPlaca;
	}

}
