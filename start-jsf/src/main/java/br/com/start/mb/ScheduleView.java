package br.com.start.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.AgendaxpEntity;
import br.com.start.facade.AgendaCalendarioFacade;

@ViewScoped
@Named
public class ScheduleView implements Serializable {

	private static final long serialVersionUID = 6494118857697268480L;

	@Inject
	private AgendaCalendarioFacade agendaFacade;

	@Inject
	private AgendaxpEntity agenda;

	private ScheduleModel eventModel;

	private List<AgendaxpEntity> agendas;

	@PostConstruct
	public void inicia() {
		this.agenda = new AgendaxpEntity();
		this.eventModel = new DefaultScheduleModel();
		try {
			agendas = new ArrayList<>();
			agendas = agendaFacade.all();

			if (!agendas.isEmpty()) {

				for (AgendaxpEntity umaAgenda : agendas) {
					DefaultScheduleEvent evt = new DefaultScheduleEvent();
					evt.setEndDate(umaAgenda.getDataFim());
					evt.setStartDate(umaAgenda.getDataInicio());
					evt.setTitle(umaAgenda.getTitulo());
					evt.setData(umaAgenda.getId());
					evt.setDescription(umaAgenda.getTitulo());
					evt.setAllDay(false);
					evt.setEditable(true);
					eventModel.addEvent(evt);
				}

			}
		} catch (Exception e) {
			FacesUtil.addErrorMessage("Erro: " + e.getMessage());
		}

	}

	public void selecionado(SelectEvent selecetEvent) {
		ScheduleEvent evt = (ScheduleEvent) selecetEvent.getObject();

		for (AgendaxpEntity umaAgenda : agendas) {
			if (umaAgenda.getId() == (Long) evt.getData()) {
				agenda = umaAgenda;
				break;
			}
		}
	}

	public void novaAgenda(SelectEvent selecetEvent) {
		ScheduleEvent evt = new DefaultScheduleEvent("", (Date) selecetEvent.getObject(),
				(Date) selecetEvent.getObject());
		agenda = new AgendaxpEntity();
		agenda.setDataInicio(evt.getStartDate());
		agenda.setDataFim(evt.getEndDate());
	}

	public void save() {
		if (agenda.getId() == null) {
			if (agenda.getDataInicio().getTime() <= agenda.getDataFim().getTime()) {
				if (!StringUtils.isEmpty(agenda.getTitulo())) {
					agendaFacade.save(agenda);
					inicia();
				} else {
					FacesUtil.addErrorMessage("Data inicial não pode ser maior que a data final ");
				}
			}
			agenda = new AgendaxpEntity();

		}
	}

	public AgendaxpEntity getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaxpEntity agenda) {
		this.agenda = agenda;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public List<AgendaxpEntity> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<AgendaxpEntity> agendas) {
		this.agendas = agendas;
	}

}