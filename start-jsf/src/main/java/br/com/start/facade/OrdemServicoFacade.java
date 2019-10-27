package br.com.start.facade;

import java.util.List;

import br.com.start.entity.OrdemServico;
import br.com.start.entity.Servico;
import br.com.start.entity.ServicoOrdemServico;
import br.com.start.entity.Veiculo;

public interface OrdemServicoFacade {
	public void grava(OrdemServico Ordemservico, List<Servico> servicos);
	public List<OrdemServico> all();
	public void remove(OrdemServico servico);
	public List<OrdemServico> selected(String value);
	public OrdemServico get(Long id);
	public Veiculo recuperaVeiculoPelaPlaca(String placa);
	public List<ServicoOrdemServico> recuperaServicoOrdemServicos(Long orderServicoId);
	
}
