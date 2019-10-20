package br.com.start.security;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

//PhaseListener
public class Autorizador {
	private static final long serialVersionUID = 1L;
	
	/*
	String usuarioLogado ="dsadsa";

	@Override
	public void afterPhase(PhaseEvent event) {
		
        FacesContext ctx = FacesContext.getCurrentInstance();
        Application app = ctx.getApplication();
        
        String pagina = ctx.getViewRoot().getViewId();
        
        String veiculoman = "veiculoman.xhtml";
        String pessoaman = "pessoaman.xhtml";
        if (!pagina.equals(veiculoman) || !pagina.equals(pessoaman)) {
        	 NavigationHandler handler = app.getNavigationHandler();
             handler.handleNavigation(ctx, "", "login?faces-redirect=false");
             ctx.renderResponse();
		} 
        
	}

	@Override
	public void beforePhase(PhaseEvent event) {
        //System.out.println("FASE: " + event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
	}

*/
}
