package br.com.start.converte;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.start.entity.AgendaContadoEntity;

@FacesConverter(forClass = AgendaContadoEntity.class)
public class AgendaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (AgendaContadoEntity) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if (value instanceof AgendaContadoEntity) {
			AgendaContadoEntity agenda = (AgendaContadoEntity) value;
			if (agenda != null && agenda instanceof AgendaContadoEntity && agenda.getId() != null) {
				uiComponent.getAttributes().put(agenda.getId().toString(), agenda);
				return agenda.getId().toString();
			}
		}
		return "";
	}
}