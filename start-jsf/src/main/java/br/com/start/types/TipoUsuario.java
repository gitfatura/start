package br.com.start.types;

public enum TipoUsuario {
	
	ADMIN("Admin"),
	FUNCIONARIOINTERNO("Funcionariolocal"),
	CARROA("Carroa"),
	CARROB("Carrob"),
	CARROC("Carroc"),
	CARROD("Carrod"),
	CARROE("Carroe"),
	CARROF("Carrof"),
	CARROG("Carrog");
	
	private String label;
	
	private TipoUsuario(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
