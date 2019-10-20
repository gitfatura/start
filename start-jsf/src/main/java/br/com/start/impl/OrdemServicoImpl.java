package br.com.start.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.start.as.OrdemServicoAS;
import br.com.start.bo.OrdemServicoBO;
import br.com.start.entity.OrdemServico;
import br.com.start.entity.Servico;
import br.com.start.entity.Veiculo;
import br.com.start.facade.OrdemServicoFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class OrdemServicoImpl implements Serializable, OrdemServicoFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private OrdemServicoBO ordemServicoBO;

	@Inject
	private OrdemServicoAS ordemServicoAS;

	@Transactional
	@Override
	public void remove(OrdemServico servico) {
		ordemServicoBO.remove(servico);
	}

	@Override
	public List<OrdemServico> all() {
		return ordemServicoBO.all();
	}

	@Override
	public List<OrdemServico> selected(String value) {
		return ordemServicoBO.selected(value);
	}

	@Override
	public OrdemServico get(Long id) {
		return ordemServicoBO.get(id);
	}

	@Override
	public Veiculo recuperaVeiculoPelaPlaca(String placa) {
		return ordemServicoBO.recuperaVeiculoPelaPlaca(placa);
	}

	@Transactional
	@Override
	public void grava(OrdemServico ordemservico, List<Servico> servicos) {
		ordemServicoAS.gravaOrdemServicos(ordemservico,servicos);
	}

}
