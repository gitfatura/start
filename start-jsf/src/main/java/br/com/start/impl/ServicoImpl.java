package br.com.start.impl;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import br.com.start.bo.ServicoBO;
import br.com.start.entity.Servico;
import br.com.start.facade.ServicoFacade;
import br.com.start.jpa.Transactional;

@ApplicationScoped
public class ServicoImpl implements Serializable, ServicoFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private ServicoBO servicoBO;

	@Transactional
	@Override
	public void grava(Servico servico) {
		servicoBO.grava(servico);
	}

	@Transactional
	@Override
	public void remove(Servico servico) {
		servicoBO.remove(servico);
	}

	@Override
	public List<Servico> all() {
		return servicoBO.all();
	}

	@Override
	public List<Servico> selected(String value) {
		return servicoBO.selected(value);
	}

	@Override
	public Servico get(Long id) {
		return servicoBO.get(id);
	}
	
	@Override
	public List<Servico> recuperaServicos(String descricao){
		return servicoBO.recuperaServicos(descricao);
	}

	@Override
	public boolean existeServico(String codigo) {
		return servicoBO.existeRegistro(codigo);
	}

}
