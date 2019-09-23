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
public class ClienteConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private PessoaFacade pessoaFacade;

	@Inject
	private Pessoa cliente;

	private String pesquisa;

	private String tipoPessoaStr;

	private List<Pessoa> clientes;

	@PostConstruct
	public void start() {
		carregaClientes();
	}

	public void carregaClientes() {
		clientes = new ArrayList<>();
		boolean ehPessoaFisica = StringUtils.isNotBlank(tipoPessoaStr) &&
				TipoPessoa.PESSOAFISICA.equals(TipoPessoa.valueOf(tipoPessoaStr));
		boolean ehPessoaJuridica = StringUtils.isNotBlank(tipoPessoaStr) &&
				TipoPessoa.PESSOAJURIDICA.equals(TipoPessoa.valueOf(tipoPessoaStr));
		clientes = pessoaFacade.recuperaPeloTipoPessoa(pesquisa, false, ehPessoaFisica, ehPessoaJuridica);
	}

	public void remove() {
		pessoaFacade.remove(cliente);
		FacesUtil.addInfoMessage("Registro removido com sucesso!");
		carregaClientes();
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

	public String getTipoPessoaStr() {
		return tipoPessoaStr;
	}

	public void setTipoPessoaStr(String tipoPessoaStr) {
		this.tipoPessoaStr = tipoPessoaStr;
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

}
