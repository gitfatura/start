package br.com.start.mb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.start.comum.DataUtil;
import br.com.start.comum.FacesUtil;
import br.com.start.entity.ClienteEntity;
import br.com.start.entity.DespesaEntity;
import br.com.start.facade.ClienteFacade;
import br.com.start.facade.DespesaFacade;
import br.com.start.facade.ICrudMB;


@ViewScoped
@Named
public class DespesaManMB implements Serializable, ICrudMB {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private DespesaFacade despesaFacade;

	@Inject
	private ClienteFacade clienteFacade;

	@Inject
	private DespesaEntity despesa;
	
	private List<ClienteEntity> clientes;
	
	private List<DespesaEntity> despesas;

	private String valorStr;

	private Integer numeroRepeticao = 0;

	private boolean geraParcela = false;

	private String situacao;

	@PostConstruct
	public void inicia() {
		recuperaCliente();
		recuperaDespesa();
	}

	private void recuperaCliente() {
		clientes = clienteFacade.all();
	}
	
	private void recuperaDespesa() {
		despesas = despesaFacade.all();
	}

	@Override
	public void grava() {
		if (StringUtils.isNotEmpty(valorStr)) {
			despesa.setValor(new BigDecimal(valorStr.trim().replace(".", "").replace(",", ".")));
		}
		if (StringUtils.isNotEmpty(situacao)) {
			if ("1".equals(situacao)) {// 1 = Repetir 2 = nao repetir
				geraParcela = true;
				despesa.setSituacao(1);
			} else {
				despesa.setSituacao(2);
			}
		}

		if (numeroRepeticao == 0) {
			Date dataProximoMes = DataUtil.proximaDataMes(despesa.getDataVencimento());

			despesa.setDataVencimento(dataProximoMes);
			despesaFacade.save(this.despesa);
			DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			FacesUtil.addInfoMessage(
					"Foram gerada " + 1 + " parcela com a data de vencimento: " + sdf.format(dataProximoMes));
		}

		if (numeroRepeticao > 0) {
			List<String> datas = new ArrayList<>();
			DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataFatura = despesa.getDataVencimento();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dataFatura);

			int contadorRepeticao = 1;
			for (int i = 0; i < numeroRepeticao; i++) {
				calendar.add(Calendar.MONTH, 1);
				Date dataRepeticao = calendar.getTime();
				despesa.setDataVencimento(dataRepeticao);
				despesaFacade.save(despesa);
				datas.add(sdf.format(dataRepeticao));
				contadorRepeticao++;
			}

			int contadorParcelas = 1;
			FacesUtil.addInfoMessage("Foram geradas " + contadorRepeticao + " parcelas: ");

			for (String umaData : datas) {
				FacesUtil.addInfoMessage("Parcela " + contadorParcelas + " com a data de vencimento: " + umaData);
				contadorParcelas++;
			}

		}
		limpar();
	}

	public void limpar() {
		despesa = new DespesaEntity();
	}

	public DespesaEntity getDespesa() {
		return despesa;
	}

	public void setDespesa(DespesaEntity despesa) {
		this.despesa = despesa;
	}

	public String getValorStr() {
		return valorStr;
	}

	public void setValorStr(String valorStr) {
		this.valorStr = valorStr;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Integer getNumeroRepeticao() {
		return numeroRepeticao;
	}

	public void setNumeroRepeticao(Integer numeroRepeticao) {
		this.numeroRepeticao = numeroRepeticao;
	}

	public boolean isGeraParcela() {
		return geraParcela;
	}

	public void setGeraParcela(boolean geraParcela) {
		this.geraParcela = geraParcela;
	}

	public List<ClienteEntity> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteEntity> clientes) {
		this.clientes = clientes;
	}

	public List<DespesaEntity> getDespesas() {
		return despesas;
	}

	public void setDespesas(List<DespesaEntity> despesas) {
		this.despesas = despesas;
	}
	
	

}
