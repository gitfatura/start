package br.com.start.types;

public enum Sexo {
	M("Masculino"), 
	F("Feminino"), 
	N("Não definido");

	private String label;

	private Sexo(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
