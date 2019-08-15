package br.com.start.types;

public enum Status {

	CANCELADO("Cancelado"), FINALIZADO("Finalizado"), ABERTO("Em aberto");

	private String label;

	private Status(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
