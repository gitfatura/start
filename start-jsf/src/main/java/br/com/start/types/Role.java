package br.com.start.types;

public enum Role {

	ADMIN("Administrador"), 
	FUNCIONARIO("Funcionário");

	private String label;

	private Role(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
