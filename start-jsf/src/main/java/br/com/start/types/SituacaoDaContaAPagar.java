package br.com.start.types;

public enum SituacaoDaContaAPagar {

	PAGA("Paga"), 
	ABERTA("Aberta");

	private String label;

	private SituacaoDaContaAPagar(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
