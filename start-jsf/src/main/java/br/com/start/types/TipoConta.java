package br.com.start.types;

public enum TipoConta {

	APAGAR("A pagar"), 
	RECEBER("A receber");

	private String label;

	private TipoConta(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
