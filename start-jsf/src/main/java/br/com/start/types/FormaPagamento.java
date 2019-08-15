package br.com.start.types;

public enum FormaPagamento {

	DINHEIRO("Dinheiro"),
	CARTAO("Cartao"),
	CHEQUE("Cheque"),
	BOLETO("Boleto");
	
	private String formaPagamento;
	
	private FormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public String getFormaPagamento() {
		return formaPagamento;
	}
	
}
