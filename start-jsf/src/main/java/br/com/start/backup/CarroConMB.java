package br.com.start.backup;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class CarroConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;
	/**
	@Inject
	private CarroFacade carroFacade;

	@Inject
	private CarroEntity carro;

	private String pesquisa;

	private List<CarroEntity> carros;

	public void recuperaAgendasSelecionada() {
		if (StringUtils.isNotEmpty(pesquisa)) {
			carros = new ArrayList<>();
			carros = carroFacade.selected(pesquisa);
		} else {
			carros = carroFacade.all();
		}

	}

	public void remove() {
		carroFacade.remove(carro);
		FacesUtil.addInfoMessage("Registro removido com sucesso!");
		recuperaAgendas();
	}

	private void recuperaAgendas() {
		carros = carroFacade.all();
	}

	public CarroEntity getCarro() {
		return carro;
	}

	public void setCarro(CarroEntity carro) {
		this.carro = carro;
	}

	public List<CarroEntity> getCarros() {
		return carros;
	}

	public void setCarros(List<CarroEntity> carros) {
		this.carros = carros;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
*/
}
