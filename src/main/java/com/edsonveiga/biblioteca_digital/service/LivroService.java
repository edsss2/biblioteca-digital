package com.edsonveiga.biblioteca_digital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edsonveiga.biblioteca_digital.entity.Livro;

@Service
public interface LivroService {

	List<Livro> listarTodos();
	Livro buscarPorId(Long id);
	Livro excluirPorId(Long id);
	List<Livro> buscarPorAutor(String autor);
	Livro salvar(Livro livro);
}
