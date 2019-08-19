package br.com.start.types;

public enum Situacao {

	PAGA("Paga"), 
	ABERTA("Aberta"), 
	CANCELADA("Cancelada");

	private String label;

	private Situacao(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
