package br.com.start.types;

public enum TipoPessoaAux {

	PESSOAFISICA("Pessoa física"),
	PESSOAJURIDICA("Pessoa jurídica");

	private String label;

	private TipoPessoaAux(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
