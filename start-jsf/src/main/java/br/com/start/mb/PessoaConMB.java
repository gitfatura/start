package br.com.start.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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
public class PessoaConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private PessoaFacade pessoaFacade;

	@Inject
	private Pessoa pessoa;

	private String pesquisa;

	private String tipoPessoaStr;

	private List<Pessoa> pessoas;

	@PostConstruct
	public void start() {
		carregaPessoas();
	}

	public void carregaPessoas() {
		if (StringUtils.isNotEmpty(pesquisa) || StringUtils.isNotEmpty(tipoPessoaStr)) {
			pessoas = new ArrayList<>();
			TipoPessoa tipoPessoa = null;
			if (StringUtils.isNotEmpty(tipoPessoaStr)) {
				tipoPessoa = TipoPessoa.valueOf(tipoPessoaStr);
			}
			pessoas = pessoaFacade.recuperaPeloTipoPessoa(pesquisa, tipoPessoa);
		} else {
			pessoas = pessoaFacade.all();
		}
	}

	public void remove() {
		pessoaFacade.remove(pessoa);
		FacesUtil.addInfoMessage("Registro removido com sucesso!");
		carregaPessoas();
	}

	public TipoPessoa[] getTipoPessoas() {
		return TipoPessoa.values();
	}
	
	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
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

	public String getTipoPessoaStr() {
		return tipoPessoaStr;
	}

	public void setTipoPessoaStr(String tipoPessoaStr) {
		this.tipoPessoaStr = tipoPessoaStr;
	}

}
