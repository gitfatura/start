package br.com.start.converte;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.start.entity.CategoriaEntity;

@FacesConverter(forClass = CategoriaEntity.class)
public class CategoriaConverter implements Converter {

	@Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (CategoriaEntity) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof CategoriaEntity) {
        	CategoriaEntity categoria = (CategoriaEntity) value;
            if (categoria != null && categoria instanceof CategoriaEntity && categoria.getId() != null) {
                uiComponent.getAttributes().put( categoria.getId().toString(), categoria);
                return categoria.getId().toString();
            }
        }
        return "";
    }

}