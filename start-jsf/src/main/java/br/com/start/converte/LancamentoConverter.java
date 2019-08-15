package br.com.start.converte;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;




public class LancamentoConverter {
//	  @Override
//	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
//	        if (value != null && !value.isEmpty()) {
//	            return (LancamentoEntity) uiComponent.getAttributes().get(value);
//	        }
//	        return null;
//	    }
//
//	    @Override
//	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
//	        if (value instanceof LancamentoEntity) {
//	        	LancamentoEntity lancamento = (LancamentoEntity) value;
//	            if (lancamento != null && lancamento instanceof LancamentoEntity && lancamento.getId() != null) {
//	                uiComponent.getAttributes().put( lancamento.getId().toString(), lancamento);
//	                return lancamento.getId().toString();
//	            }
//	        }
//	        return "";
//	    }
//		
//	
}
