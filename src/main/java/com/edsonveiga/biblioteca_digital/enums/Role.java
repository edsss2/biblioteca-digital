package com.edsonveiga.biblioteca_digital.enums;

public enum Role {

	BIBLIOTECARIO("Bibliotecário"),
	USUARIO_COMUM("Usuário");
	
	private final String nome;
	
	Role(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
