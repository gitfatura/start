package br.com.start.mb;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.start.comum.FacesUtil;
import br.com.start.entity.LancamentoEntity;
import br.com.start.facade.LancamentoFacade;
import br.com.start.types.OpcaoLancamento;
import br.com.start.types.TipoLancamento;

@ViewScoped
@Named
public class LancamentoManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private LancamentoFacade lancamentoFacade;

	@Inject
	private LancamentoEntity lancamento;

	private String tipoLancamentoSelecionado;
	private String opcaoLancamentoSelecionado;

	private String valorPrevisto;
	private String valorRealizado;

	@PostConstruct
	public void inicia() {
		recuperaLancamento();
	}

	public void grava() {
		lancamento.setValorPrevisto(new BigDecimal(valorPrevisto.trim().replace(".", "").replace(",", ".")));
		lancamento.setValorRealizado(new BigDecimal(valorRealizado.trim().replace(".", "").replace(",", ".")));

		if ("1".equals(tipoLancamentoSelecionado)) {
			lancamento.setTipoLancamento(TipoLancamento.SAIDA);
		} else {
			lancamento.setTipoLancamento(TipoLancamento.ENTRADA);
		}

		if (StringUtils.isNotEmpty(opcaoLancamentoSelecionado)) {
			if ("1".equals(opcaoLancamentoSelecionado)) {
				lancamento.setOpcaoLancamento(OpcaoLancamento.UNICO);
			} else {
				lancamento.setOpcaoLancamento(OpcaoLancamento.PARCELADO);
			}

		}
		lancamentoFacade.save(this.lancamento);
		limpar();
		FacesUtil.addInfoMessage("Registro gravado com sucesso!");

	}

	public void limpar() {
		lancamento = new LancamentoEntity();
		tipoLancamentoSelecionado = null;
		opcaoLancamentoSelecionado = null;
		valorPrevisto = null;
		valorRealizado = null;
	}

	private void recuperaLancamento() {
		String idLancamento = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(idLancamento) && StringUtils.isNotBlank(idLancamento)) {
			this.lancamento = lancamentoFacade.get(Long.valueOf(idLancamento));

			TipoLancamento tipoLancamento = lancamento.getTipoLancamento();
			OpcaoLancamento opcaoLancamento = lancamento.getOpcaoLancamento();

			if (tipoLancamento != null) {
				if (tipoLancamento.equals(TipoLancamento.SAIDA)) {
					tipoLancamentoSelecionado = "1";
				} else {
					tipoLancamentoSelecionado = "2";
				}
			}

			if (opcaoLancamento != null) {
				if (opcaoLancamento.equals(OpcaoLancamento.UNICO)) {
					opcaoLancamentoSelecionado = "1";
				} else {
					opcaoLancamentoSelecionado = "2";
				}
			}

			valorPrevisto = String.valueOf(lancamento.getValorPrevisto());
			valorRealizado = String.valueOf(lancamento.getValorRealizado());

		}
	}

	public LancamentoEntity getLancamento() {
		return lancamento;
	}

	public void setLancamento(LancamentoEntity lancamento) {
		this.lancamento = lancamento;
	}

	public String getTipoLancamentoSelecionado() {
		return tipoLancamentoSelecionado;
	}

	public void setTipoLancamentoSelecionado(String tipoLancamentoSelecionado) {
		this.tipoLancamentoSelecionado = tipoLancamentoSelecionado;
	}

	public String getValorPrevisto() {
		return valorPrevisto;
	}

	public void setValorPrevisto(String valorPrevisto) {
		this.valorPrevisto = valorPrevisto;
	}

	public String getValorRealizado() {
		return valorRealizado;
	}

	public void setValorRealizado(String valorRealizado) {
		this.valorRealizado = valorRealizado;
	}

	public String getOpcaoLancamentoSelecionado() {
		return opcaoLancamentoSelecionado;
	}

	public void setOpcaoLancamentoSelecionado(String opcaoLancamentoSelecionado) {
		this.opcaoLancamentoSelecionado = opcaoLancamentoSelecionado;
	}

}
