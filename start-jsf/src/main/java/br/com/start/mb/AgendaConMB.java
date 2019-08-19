package br.com.start.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class AgendaConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	/**
	@Inject
	private AgendaFacade agendaFacade;

	@Inject
	private AgendaContadoEntity agenda;

	private String pesquisa;

	private List<AgendaContadoEntity> agendas;

	public void recuperaAgendasSelecionada() {
		if (StringUtils.isNotEmpty(pesquisa)) {
			agendas = new ArrayList<>();
			agendas = agendaFacade.selected(pesquisa);
		} else {
			agendas = agendaFacade.all();
		}

	}

	public void remove() {
		agendaFacade.remove(agenda);
		FacesUtil.addInfoMessage("Registro removido com sucesso!");
		recuperaAgendas();
	}

	private void recuperaAgendas() {
		agendas = agendaFacade.all();
	}

	public List<AgendaContadoEntity> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<AgendaContadoEntity> agendas) {
		this.agendas = agendas;
	}

	public AgendaContadoEntity getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaContadoEntity agenda) {
		this.agenda = agenda;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
*/
	
}
