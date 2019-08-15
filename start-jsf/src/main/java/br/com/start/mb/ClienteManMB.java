package br.com.start.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.ClienteEntity;
import br.com.start.facade.ClienteFacade;
import br.com.start.facade.ICrudMB;

@ViewScoped
@Named
public class ClienteManMB implements Serializable, ICrudMB {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ClienteFacade clienteFacade;

	@Inject
	private ClienteEntity cliente;

	@PostConstruct
	public void start() {
		recuperaAgenda();
	}

	@Override
	public void grava() {
		if (cliente == null) {
			FacesUtil.addErrorMessage("Erro ao registrar");
		} else {
			clienteFacade.save(cliente);
			novaInstacia();
			FacesUtil.addInfoMessage("Registro gravado com sucesso!");
		}
	}

	public void novaInstacia() {
		cliente = new ClienteEntity();
	}

	private void recuperaAgenda() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.cliente = clienteFacade.get(Long.valueOf(id));
		}
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

}
