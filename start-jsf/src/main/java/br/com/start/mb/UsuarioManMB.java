package br.com.start.mb;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.Pessoa;
import br.com.start.entity.Usuario;
import br.com.start.facade.UsuarioFacade;

@SessionScoped
@Named
public class UsuarioManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private Usuario usuario;

	@Inject
	private Pessoa pessoa;

	private List<Pessoa> pessoas;
	
	private String valorPesquisaStr;

	@Inject
	private UsuarioFacade usuarioFacade;

	@PostConstruct
	public void start() {
		recuperaFuncionarios();
	}
	
	public void recuperaFuncionarios() {
		pessoas = usuarioFacade.recuperaFuncionarios(valorPesquisaStr);
	}

	
	public List<Pessoa> completarPessoa(String valor) {
		return usuarioFacade.recuperaFuncionarios(valor);
	}

	public void pessoaSelecionada(SelectEvent event) {
		pessoa = (Pessoa) event.getObject();
	}

	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);
		PrimeFaces.current().dialog().openDynamic("selecaofuncionarios", opcoes, null);
	}
	
	public void selecionar(Pessoa pessoa) {
		PrimeFaces.current().dialog().closeDynamic(pessoa);
	}

	public void novaInstacia() {
		usuario = new Usuario();
		pessoa = new Pessoa();
	}

	public void grava() {

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
					return "/dashboard.xhtml?faces-redirect=false";
				}
			}

		} catch (Exception e) {
			FacesUtil.addInfoMessageWarn("Usuário ou senha incorreto.");
		}
		return "/login.xhtml?faces-redirect=false";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String getValorPesquisaStr() {
		return valorPesquisaStr;
	}

	public void setValorPesquisaStr(String valorPesquisaStr) {
		this.valorPesquisaStr = valorPesquisaStr;
	}
	

}
