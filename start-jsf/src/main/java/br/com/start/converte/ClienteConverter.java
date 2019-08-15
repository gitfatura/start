package br.com.start.converte;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.start.entity.ClienteEntity;

@FacesConverter(forClass = ClienteEntity.class)
public class ClienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (ClienteEntity) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if (value instanceof ClienteEntity) {
			ClienteEntity cliente = (ClienteEntity) value;
			if (cliente != null && cliente instanceof ClienteEntity && cliente.getId() != null) {
				uiComponent.getAttributes().put(cliente.getId().toString(), cliente);
				return cliente.getId().toString();
			}
		}
		return "";
	}

}