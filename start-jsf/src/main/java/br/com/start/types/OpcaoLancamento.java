package br.com.start.types;

public enum OpcaoLancamento {

	UNICO("Unico"), PARCELADO("Parcelado");

	private String label;

	private OpcaoLancamento(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
