package br.com.start.types;

public enum TipoFiado {

	EUDEVO("Eu devo"),
	MEDEVEM("Me devem");
	
	private String label;
	
	
	private TipoFiado(String label) {
		this.label = label;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
	
	
	
}
