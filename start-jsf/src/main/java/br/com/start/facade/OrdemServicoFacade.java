package br.com.start.facade;

import java.util.List;
import br.com.start.entity.OrdemServico;

public interface OrdemServicoFacade {
	public void grava(OrdemServico servico);
	public List<OrdemServico> all();
	public void remove(OrdemServico servico);
	public List<OrdemServico> selected(String value);
	public OrdemServico get(Long id);
}
