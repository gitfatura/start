package br.com.start.types;

public enum TipoLancamento {

	ENTRADA("Entrada"), SAIDA("Saida");

	private String label;

	private TipoLancamento(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
