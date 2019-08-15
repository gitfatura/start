package br.com.start.types;

public enum Finalizado {

	SIM("Finalizado"),
	NAO("Em aberto");
	
	private String label;
	
	
	private Finalizado(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
