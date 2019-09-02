package br.com.start.backup;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class AgendaManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	/**
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
*/
}
