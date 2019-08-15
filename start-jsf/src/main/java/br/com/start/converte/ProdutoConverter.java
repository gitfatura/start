package br.com.start.converte;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.start.entity.ProdutoEntity;

@FacesConverter(forClass = ProdutoEntity.class)
public class ProdutoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (ProdutoEntity) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if (value instanceof ProdutoEntity) {
			ProdutoEntity produto = (ProdutoEntity) value;
			if (produto != null && produto instanceof ProdutoEntity && produto.getId() != null) {
				uiComponent.getAttributes().put(produto.getId().toString(), produto);
				return produto.getId().toString();
			}
		}
		return "";
	}

}