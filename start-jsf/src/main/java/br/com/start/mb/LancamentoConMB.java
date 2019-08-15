package br.com.start.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.LancamentoEntity;
import br.com.start.facade.LancamentoFacade;

@ViewScoped
@Named
public class LancamentoConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private LancamentoFacade lancamentoFacade;

	@Inject
	private LancamentoEntity lancamento;

	private String pesquisa;

	private List<LancamentoEntity> lancamentos;

	public void recuperaLancamentoSelecionado() {
		if (StringUtils.isNotEmpty(pesquisa)) {
			lancamentos = new ArrayList<>();
			lancamentos = lancamentoFacade.selected(pesquisa);
		} else {
			lancamentos = lancamentoFacade.all();
		}

	}

	public void remove() {
		lancamentoFacade.remove(lancamento);
		FacesUtil.addInfoMessage("Registro removido com sucesso!");
		recuperaLancamentos();
	}

	private void recuperaLancamentos() {
		lancamentos = lancamentoFacade.all();
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public LancamentoEntity getLancamento() {
		return lancamento;
	}

	public void setLancamento(LancamentoEntity lancamento) {
		this.lancamento = lancamento;
	}

	public List<LancamentoEntity> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<LancamentoEntity> lancamentos) {
		this.lancamentos = lancamentos;
	}

}
