package br.com.start.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.start.comum.FacesUtil;
import br.com.start.comum.SessionUtil;
import br.com.start.entity.UsuarioEntity;
import br.com.start.facade.UsuarioFacade;

@SessionScoped
@Named
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioFacade usuarioFacade;
	
	@Inject
	private UsuarioEntity usuario;
	
	
	public String validarUsuarioESenha() {
		boolean validar = usuarioFacade.validarUsuarioESenha(usuario);
		if (validar) {
			HttpSession session = SessionUtil.getSession();
			session.setAttribute("usuario", usuario);
			return "dashboard.xhtml";
		} else {
			FacesUtil.addInfoMessageWarnLogin();
			return "login";
		}
	}
	
	public String logout(){
		HttpSession session  = SessionUtil.getSession();
		session.invalidate();
		return "login";
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	
	
	

}
