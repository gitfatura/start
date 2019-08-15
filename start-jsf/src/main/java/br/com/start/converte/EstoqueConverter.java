package br.com.start.converte;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.start.entity.EstoqueEntity;

@FacesConverter(forClass = EstoqueEntity.class)
public class EstoqueConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (EstoqueEntity) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if (value instanceof EstoqueEntity) {
			EstoqueEntity estoque = (EstoqueEntity) value;
			if (estoque != null && estoque instanceof EstoqueEntity && estoque.getId() != null) {
				uiComponent.getAttributes().put(estoque.getId().toString(), estoque);
				return estoque.getId().toString();
			}
		}
		return "";
	}

}