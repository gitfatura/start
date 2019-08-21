package br.com.start.as;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import br.com.start.bo.AvariaBO;
import br.com.start.bo.VeiculoBO;
import br.com.start.entity.Avaria;
import br.com.start.entity.Veiculo;

@ApplicationScoped
public class VeiculoAS implements Serializable {

	private static final long serialVersionUID = -2096894550279202049L;

	@Inject
	private VeiculoBO veiculoBO;

	@Inject
	private AvariaBO avariaBO;

	public void gravaVeiculo(Veiculo veiculo, List<Avaria> avarias) {

		if (avarias != null && avarias.size() > 0) {
			for (Avaria umaAvaria : avarias) {
				avariaBO.grava(umaAvaria);
			}
		}
		veiculoBO.grava(veiculo);
	}

}
