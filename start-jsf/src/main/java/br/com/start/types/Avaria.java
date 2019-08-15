package br.com.start.types;

public enum Avaria {

	PORTA("Porta amassada"),
	VIDRO("Vidro quebrado"),
	PNEU("Pneu estourados"),
	LATARIA("Lataria danificada"),
	PARACHOQUE("Parachoque danificado"),
	LANTERNA("Lataria danificada");
	
	private String label;
	
	private Avaria(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
