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
import br.com.start.entity.ClienteEntity;
import br.com.start.facade.ClienteFacade;

@ViewScoped
@Named
public class ClienteConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ClienteFacade clienteFacade;

	@Inject
	private ClienteEntity cliente;

	private String pesquisa;

	private List<ClienteEntity> clientes;

	@PostConstruct
	public void start() {
		carregaClientes();
	}

	public void carregaClientes() {
		if (StringUtils.isNotEmpty(pesquisa)) {
			clientes = new ArrayList<>();
			clientes = clienteFacade.selected(pesquisa);
		} else {
			clientes = clienteFacade.all();
		}
	}

	public void remove() {
		clienteFacade.remove(cliente);
		FacesUtil.addInfoMessage("Registro removido com sucesso!");
		carregaClientes();
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public List<ClienteEntity> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteEntity> clientes) {
		this.clientes = clientes;
	}

}
