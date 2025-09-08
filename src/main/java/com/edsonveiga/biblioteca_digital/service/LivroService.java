package com.edsonveiga.biblioteca_digital.service;

import java.util.List;

import com.edsonveiga.biblioteca_digital.entity.Livro;

public interface LivroService {

	List<Livro> listarTodos();
	Livro buscarPorId(Long id);
	Livro excluirPorId(Long id);
	List<Livro> buscarPorAutor(String autor);
	Livro salvar(Livro livro);
}
