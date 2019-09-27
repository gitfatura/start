package br.com.start.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.PrimeFaces;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.Pessoa;
import br.com.start.facade.PessoaFacade;
import br.com.start.types.TipoPessoa;

@ViewScoped
@Named
public class ClienteManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private PessoaFacade clienteFacade;

	@Inject
	private Pessoa cliente;

	private String pesquisa;

	private List<Pessoa> clientes;

	private String tipoCliente;

	@PostConstruct
	public void start() {
		recuperaClientes();
	}

	public void grava() {
		try {
			validaTipocliente(cliente);
			clienteFacade.grava(cliente);
			tipoCliente = null;
			novaInstacia();
			FacesUtil.addInfoMessage("Registro gravado com sucesso!");
		} catch (Exception e) {
			trataMensagemDeErro(e);
		}
	}

	private void validaTipocliente(Pessoa cliente) {
		if (StringUtils.isNotBlank(tipoCliente)) {
			TipoPessoa tipoclienteAux = TipoPessoa.valueOf(tipoCliente);

			if (TipoPessoa.PESSOAFISICA.equals(tipoclienteAux)) {
				cliente.setCnpj(null);
				cliente.setTipoPessoa(tipoclienteAux);
			} else {
				cliente.setCpf(null);
				cliente.setTipoPessoa(tipoclienteAux);
			}
		}
	}

	private void trataMensagemDeErro(Exception e) {
		if (e.getCause().getMessage().contains("ConstraintViolationException:")) {
			TipoPessoa tipoclienteAux = cliente.getTipoPessoa();

			if (TipoPessoa.PESSOAFISICA.equals(tipoclienteAux)) {
				FacesUtil.addErrorMessageFatal("Cpf: " + cliente.getCpf() + " já cadastrado.");
			}
			if (TipoPessoa.PESSOAJURIDICA.equals(cliente.getTipoPessoa())) {
				FacesUtil.addErrorMessageFatal("Cnpj: " + cliente.getCnpj() + " já cadastrado.");
			}
		}
	}

	private void recuperaClientes() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.cliente = clienteFacade.get(Long.valueOf(id));
			tipoCliente = String.valueOf(cliente.getTipoPessoa());
		}
	}

	public void novaInstacia() {
		cliente = new Pessoa();
		PrimeFaces.current().resetInputs("frm:panelcliente");
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public List<Pessoa> getClientes() {
		return clientes;
	}

	public void setClientes(List<Pessoa> clientes) {
		this.clientes = clientes;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

}