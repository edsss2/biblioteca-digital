package com.edsonveiga.biblioteca_digital.entity;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O título não pode ser vazio.")
	@Size(min = 2, max = 100, message = "O título deve ter entre 2 e 100 caracteres.")
	private String titulo;
	
	@NotBlank(message = "O auto não pode ser vazio.")
	private String autor;
	private String sinopse;
	
	@NotNull(message = "O ano de publicação é obrigatório.")
	private Integer anoPublicacao;

	public Livro(Long id, String titulo, String autor, String sinopse) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.sinopse = sinopse;
	}

	public Integer getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Integer anoLancamento) {
		this.anoPublicacao = anoLancamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

}
