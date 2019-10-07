package br.com.start.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.Servico;
import br.com.start.facade.ServicoFacade;

@ViewScoped
@Named
public class ServicoManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ServicoFacade servicoFacade;

	@Inject
	private Servico servico;

	private String valorStr;

	@PostConstruct
	public void start() {
		recuperaServico();
	}

	public void grava() {
		if (!validaServico(servico)) {
			servicoFacade.grava(servico);
			novaInstancia();
			FacesUtil.addInfoMessage("Registro gravado com sucesso!");
		} else {
			FacesUtil.addErrorMessageFatal("Código " + servico.getCodigo() + " já cadastrado.");
		}

	}

	private boolean validaServico(Servico servico) {
		return servicoFacade.existeServico(StringUtils.isNotBlank(servico.getCodigo()) ? servico.getCodigo() : null);
	}

	public void novaInstancia() {
		servico = new Servico();
		valorStr = null;
	}

	private void recuperaServico() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.servico = servicoFacade.get(Long.valueOf(id));
		}
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public String getValorStr() {
		return valorStr;
	}

	public void setValorStr(String valorStr) {
		this.valorStr = valorStr;
	}

}
