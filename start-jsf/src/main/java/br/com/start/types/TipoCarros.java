package br.com.start.types;

public enum TipoCarros {
	
	CARROA("Estoque Carro A"),
	CARROB("Estoque Carro B"),
	CARROC("Estoque Carro C"),
	CARROD("Estoque Carro D"),
	CARROE("Estoque Carro E"),
	CARROF("Estoque Carro F");
	
	private String label;
	
	private TipoCarros(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	

}
