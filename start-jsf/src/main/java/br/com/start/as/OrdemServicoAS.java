package br.com.start.as;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.ServicoBO;
import br.com.start.entity.Servico;

@ApplicationScoped
public class OrdemServicoAS implements Serializable {
	private static final long serialVersionUID = 6129618031504662884L;

	@Inject
	private ServicoBO servicoBO;

	public void gravaServico(List<Servico> servicos) {
		for (Servico umServico : servicos) {
			servicoBO.grava(umServico);
		}

	}

}