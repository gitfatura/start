package br.com.start.mb;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.start.comum.FacesUtil;
import br.com.start.entity.Pessoa;
import br.com.start.facade.PessoaFacade;

@ViewScoped
@Named
public class FuncionarioConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private PessoaFacade pessoaFacade;

	@Inject
	private Pessoa funcionario;

	private String pesquisa;

	private List<Pessoa> funcionarios;

	@PostConstruct
	public void start() {
		carregaFunarios();
	}

	public void carregaFunarios() {
		funcionarios = pessoaFacade.recuperaPeloTipoPessoa(pesquisa, true, false, false);
	}

	public void remove() {
		pessoaFacade.remove(funcionario);
		FacesUtil.addInfoMessage("Registro removido com sucesso!");
		carregaFunarios();
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public List<Pessoa> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Pessoa> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Pessoa getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Pessoa funcionario) {
		this.funcionario = funcionario;
	}

}
