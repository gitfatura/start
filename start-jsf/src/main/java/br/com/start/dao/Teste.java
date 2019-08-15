package br.com.start.dao;

import java.math.BigDecimal;

public class Teste {

	public static void main(String[] args) {
		
		String valorStr ="1,50";
		BigDecimal valor = new BigDecimal(valorStr.trim().replace(".", "").replace(",", "."));
		
		System.out.println(valor);

	}

}
