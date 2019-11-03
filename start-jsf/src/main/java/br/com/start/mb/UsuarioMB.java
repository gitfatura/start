package br.com.start.mb;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import br.com.start.comum.FacesUtil;
import br.com.start.comum.SessionUtil;
import br.com.start.entity.Usuario;
import br.com.start.facade.UsuarioFacade;

@SessionScoped
@Named
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private Usuario usuario;
	
	@Inject
	private UsuarioFacade usuarioFacade;

	@PostConstruct
	public void start() {
		System.out.println("dsadas");
	}
	
	public String logar() {
		try {
			if (usuario == null) {
				FacesUtil.addInfoMessageWarn("Informe o Usuário e Senha.");
				return "/login.xhtml?faces-redirect=false";
			} else if (usuario != null && StringUtils.isBlank(usuario.getLogin())
					&& StringUtils.isBlank(usuario.getSenha())) {
				FacesUtil.addInfoMessageWarn("Informe Usuário e Senha.");
				return "/login.xhtml?faces-redirect=false";
			} else if (usuario != null && StringUtils.isBlank(usuario.getLogin())) {
				FacesUtil.addInfoMessageWarn("Informe Usuário.");
				return "/login.xhtml?faces-redirect=false";
			} else if (usuario != null && StringUtils.isBlank(usuario.getSenha())) {
				FacesUtil.addInfoMessageWarn("Informe Senha.");
				return "/login.xhtml?faces-redirect=false";
			} else {
				Usuario usuarioLogado = usuarioFacade.logar(usuario);
				if (usuarioLogado != null) {
					HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
					session.setAttribute("usuario", usuarioLogado);
					return "/dashboard.xhtml?faces-redirect=false";
				}
			}

		} catch (Exception e) {
			FacesUtil.addInfoMessageWarn("Usuário ou senha incorreto.");
		}
		return "/login.xhtml?faces-redirect=false";
	}
	
	public String sair() {
		SessionUtil.invalidate();
		return "/login.xhtml?faces-redirect=false";
	}
	
	public boolean isAdmin() {
		usuario = SessionUtil.getUsuario();
		if (usuario !=null) {
			return usuario.isAdmin();
		}
		return false;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
