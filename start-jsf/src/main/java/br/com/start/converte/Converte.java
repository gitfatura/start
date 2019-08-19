package br.com.start.converte;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.start.entity.AppBase;

@SuppressWarnings("rawtypes")
@FacesConverter(forClass = AppBase.class)
public class Converte implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (AppBase) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if (value instanceof AppBase) {
			AppBase app = (AppBase) value;
			if (app != null && app instanceof AppBase && app.getId() != null) {
				uiComponent.getAttributes().put(app.getId().toString(), app);
				return app.getId().toString();
			}
		}
		return "";
	}
}