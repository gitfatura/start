package br.com.start.as;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.bo.OrdemServicoBO;
import br.com.start.entity.OrdemServico;
import br.com.start.entity.Servico;

@ApplicationScoped
public class OrdemServicoAS implements Serializable {
	private static final long serialVersionUID = 6129618031504662884L;

	@Inject
	private OrdemServicoBO ordemServicoBO;

	public void gravaOrdemServicos(OrdemServico ordemservico, List<Servico> servicos) {
		for (Servico umServico : servicos) {
			ordemservico.setServico(umServico);
			ordemServicoBO.grava(ordemservico);
		}

	}

}