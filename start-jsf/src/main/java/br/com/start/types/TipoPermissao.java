package br.com.start.types;

public enum TipoPermissao {
	
	A("Acesso total"), //Acesso total
	B("Somente consulta"), // Somente consulta
	C("Alterar"),// Somente altera atualiza
	D("Excluir");// Excluir
	
	
	private String label;
	
	private TipoPermissao(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
