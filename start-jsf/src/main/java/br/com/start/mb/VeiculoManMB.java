package br.com.start.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class VeiculoManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	/*
	@Inject
	private VeiculoFacade veiculoFacade;

	@Inject
	private PessoaFisicaFacade pessoaFisicaFacade;

	@Inject
	private Veiculo carro;

	private List<ClienteEntity> clientes;

	@PostConstruct
	public void start() {
		recuperaCarro();
		recuperaCarros();
	}

	public void grava() {
		if (carro == null) {
			FacesUtil.addErrorMessage("Erro ao registrar");
		} else {
			carroFacade.save(carro);
			limpar();
			FacesUtil.addInfoMessage("Registro gravado com sucesso!");
		}
	}

	public void recuperaCarros() {
		clientes = clienteFacade.all();
	}

	public void limpar() {
		carro = new CarroEntity();
	}

	private void recuperaCarro() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.carro = carroFacade.get(Long.valueOf(id));
		}
	}

	public CarroEntity getCarro() {
		return carro;
	}

	public void setCarro(CarroEntity carro) {
		this.carro = carro;
	}

	public List<ClienteEntity> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteEntity> clientes) {
		this.clientes = clientes;
	}
*/
}
