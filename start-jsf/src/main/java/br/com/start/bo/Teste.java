package br.com.start.bo;

import br.com.start.types.TipoPessoa;

public class Teste {

	public static void main(String[] args) {

		TipoPessoa[] tipoPessoas = {TipoPessoa.FUNCIONARIO, TipoPessoa.PESSOAFISICA};
		
		for (TipoPessoa tipoPessoa : tipoPessoas) {
			System.out.println(tipoPessoa);
		}
		
		
	}

}
