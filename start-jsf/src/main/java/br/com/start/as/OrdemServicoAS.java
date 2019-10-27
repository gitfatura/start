package br.com.start.as;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import br.com.start.bo.OrdemServicoBO;
import br.com.start.entity.OrdemServico;
import br.com.start.entity.Servico;
import br.com.start.entity.ServicoOrdemServico;
import br.com.start.types.Status;

@ApplicationScoped
public class OrdemServicoAS implements Serializable {
	private static final long serialVersionUID = 6129618031504662884L;

	@Inject
	private OrdemServicoBO ordemServicoBO;
	
	public void gravaOrdemServicos(OrdemServico ordemservico, List<Servico> servicos) {
		ServicoOrdemServico servicoOrdemServico =  null;
		List<ServicoOrdemServico> servicoOrdemServicos = new ArrayList<ServicoOrdemServico>();
		BigDecimal valorTotal = BigDecimal.ZERO;
		for (Servico umServico : servicos) {
			if (!Status.CANCELADO.equals(umServico.getStatus())) {
				valorTotal = valorTotal.add(umServico.getValor());
			}
			servicoOrdemServico = new ServicoOrdemServico();
			servicoOrdemServico.setOrdemServico(ordemservico);
			servicoOrdemServico.setServico(umServico);
			servicoOrdemServico.setStatus(umServico.getStatus());
			servicoOrdemServico.setValor(umServico.getValor());
			servicoOrdemServicos.add(servicoOrdemServico);
		}
		ordemservico.setValorTotal(valorTotal);
		ordemservico.setServicoOrdemServicos(servicoOrdemServicos);
		ordemServicoBO.grava(ordemservico);
	}
}