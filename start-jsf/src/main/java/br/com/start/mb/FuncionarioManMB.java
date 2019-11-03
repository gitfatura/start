package br.com.start.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.Pessoa;
import br.com.start.facade.PessoaFacade;
import br.com.start.types.TipoPessoa;

@ViewScoped
@Named
public class FuncionarioManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private PessoaFacade pessoaFacade;

	@Inject
	private Pessoa funcionario;

	private String pesquisa;

	private List<Pessoa> funcionarios;

	@PostConstruct
	public void start() {
		recuperaFuncionario();
	}

	public void grava() {
		try {
			if(!validaFuncionario(funcionario)) {
				pessoaFacade.grava(funcionario);
				novaInstacia();
				FacesUtil.addInfoMessage("Registro gravado com sucesso!");
			}
		} catch (Exception e) {
			FacesUtil.addErrorMessageFatal("Ocorreu erro interno: "+e.getMessage());
		}
	}

	private boolean validaFuncionario(Pessoa funcionario) {
		funcionario.setTipoPessoa(TipoPessoa.FUNCIONARIO);
		funcionario.setCnpj(null);
		boolean existePessoa = false;
		
		if(funcionario.getId() !=null) {
			Pessoa funcionarioAux = pessoaFacade.get(funcionario.getId());
			
			if(StringUtils.isNotBlank(funcionarioAux.getCpf()) && StringUtils.isNotBlank(funcionario.getCpf())) {
				boolean cpfIgual = !funcionarioAux.getCpf().equals(funcionario.getCpf());
				if(cpfIgual) {
					existePessoa = pessoaFacade.existePessoa(funcionario.getCpf(),null);
				}
			}else {
				if(StringUtils.isNotBlank(funcionario.getCpf())) {
					existePessoa = pessoaFacade.existePessoa(funcionario.getCpf(),null);
				}
			}
		}else {
			if(funcionario.getId() ==null && StringUtils.isNotBlank(funcionario.getCpf())) {
				existePessoa = pessoaFacade.existePessoa(funcionario.getCpf(),null);
			}
		}
		
		if (existePessoa) {
			FacesUtil.addErrorMessageFatal("Cpf: " + funcionario.getCpf() + " já cadastrado.");
		}
		
		return existePessoa;
	}
	
	private void recuperaFuncionario() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.funcionario = pessoaFacade.get(Long.valueOf(id));
		}
	}

	public void novaInstacia() {
		funcionario = new Pessoa();
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Pessoa getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Pessoa funcionario) {
		this.funcionario = funcionario;
	}

	public List<Pessoa> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Pessoa> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
