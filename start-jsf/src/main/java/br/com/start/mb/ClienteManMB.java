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
			if (!validaCliente(cliente)) {
				clienteFacade.grava(cliente);
				novaInstacia();
				FacesUtil.addInfoMessage("Registro gravado com sucesso!");
			} 
		} catch (Exception e) {
			FacesUtil.addErrorMessageFatal("Ocorreu erro interno: "+e.getMessage());
		}
	}

	private boolean validaCliente(Pessoa cliente) {
		TipoPessoa tipoclienteAux = TipoPessoa.valueOf(tipoCliente);
		boolean existePessoa = false;
		
		if (TipoPessoa.PESSOAFISICA.equals(tipoclienteAux)) {
			cliente.setTipoPessoa(tipoclienteAux);
			cliente.setCnpj(null);
			
			if(cliente.getId() !=null) {
				Pessoa pessoa = clienteFacade.get(cliente.getId());
				if(StringUtils.isNotBlank(pessoa.getCpf()) && StringUtils.isNotBlank(cliente.getCpf())) {
					boolean cpfIgual = !pessoa.getCpf().equals(cliente.getCpf());
					if(cpfIgual) {
						existePessoa = clienteFacade.existePessoa(cliente.getCpf(),null);
					}
				}else {
					if(StringUtils.isBlank(pessoa.getCpf())) {
						existePessoa = clienteFacade.existePessoa(cliente.getCpf(),null);
					}
				}
			}else {
				if(cliente.getId() ==null && StringUtils.isNotBlank(cliente.getCpf())) {
					existePessoa = clienteFacade.existePessoa(cliente.getCpf(),null);
				}
			}
			
			if (existePessoa) {
				FacesUtil.addErrorMessageFatal("Cpf: " + cliente.getCpf() + " já cadastrado.");
			}
		}else{
			cliente.setTipoPessoa(tipoclienteAux);
			cliente.setCpf(null);
			if(cliente.getId() !=null) {
				Pessoa pessoa = clienteFacade.get(cliente.getId());
				if(StringUtils.isNotBlank(pessoa.getCnpj()) && StringUtils.isNotBlank(cliente.getCnpj())) {
					boolean cnpjIgual = !pessoa.getCnpj().equals(cliente.getCnpj());
					if(cnpjIgual) {
						existePessoa = clienteFacade.existePessoa(null,cliente.getCnpj());
					}
				}else {
					if(StringUtils.isBlank(pessoa.getCnpj())) {
						existePessoa = clienteFacade.existePessoa(null,cliente.getCnpj());
					}
				}
			}else {
				if(cliente.getId() ==null && StringUtils.isNotBlank(cliente.getCnpj())) {
					existePessoa = clienteFacade.existePessoa(null,cliente.getCnpj());
				}
			}
			if (existePessoa) {
				FacesUtil.addErrorMessageFatal("Cnpj: " + cliente.getCnpj() + " já cadastrado.");
			}
		}
		return existePessoa;
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
		tipoCliente = null;
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
