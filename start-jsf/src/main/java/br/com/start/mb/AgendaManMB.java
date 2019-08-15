package br.com.start.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.AgendaContadoEntity;
import br.com.start.facade.AgendaFacade;
import br.com.start.facade.ICrudMB;

@ViewScoped
@Named
public class AgendaManMB implements Serializable, ICrudMB {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private AgendaFacade agendaFacade;

	@Inject
	private AgendaContadoEntity agenda;
	
	@PostConstruct
	public void inicia() {
		recuperaAgenda();
	}
	
	@Override
	public void grava() {
		if (agenda == null) {
			FacesUtil.addErrorMessage("Erro ao registrar");
		} else {
			agendaFacade.save(agenda);
			limpar();
			FacesUtil.addInfoMessage("Registro gravado com sucesso!");
		}
	}

	public void limpar() {
		agenda = new AgendaContadoEntity();
	}

	private void recuperaAgenda() {
		String idAgenda = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(idAgenda) && StringUtils.isNotBlank(idAgenda) ) {
			this.agenda = agendaFacade.get(Long.valueOf(idAgenda));
		}
	}
	
	
	public AgendaContadoEntity getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaContadoEntity agenda) {
		this.agenda = agenda;
	}

}
