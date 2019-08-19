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
import br.com.start.types.Sexo;
import br.com.start.types.TipoPessoa;

@ViewScoped
@Named
public class PessoaManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private PessoaFacade pessoaFacade;

	@Inject
	private Pessoa pessoa;

	private String pesquisa;

	private List<Pessoa> pessoas;

	@PostConstruct
	public void start() {
		recuperaPessoas();
	}

	public void grava() {
		pessoaFacade.grava(pessoa);
		novaInstacia();
		FacesUtil.addInfoMessage("Registro gravado com sucesso!");
	}

	private void recuperaPessoas() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.pessoa = pessoaFacade.get(Long.valueOf(id));
		}
	}

	public void novaInstacia() {
		pessoa = new Pessoa();
	}

	public Sexo[] getSexos() {
		return Sexo.values();
	}
	
	public TipoPessoa[] getTipoPessoas() {
		return TipoPessoa.values();
	}
	
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
