package com.edsonveiga.biblioteca_digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edsonveiga.biblioteca_digital.entity.Livro;
import com.edsonveiga.biblioteca_digital.repositorio.LivroRepositorio;
import com.edsonveiga.biblioteca_digital.service.LivroService;


public class LivroServiceImpl implements LivroService{

	private final LivroRepositorio livroRepositorio;
	
	@Autowired
	public LivroServiceImpl(LivroRepositorio livroRepositorio) {
		this.livroRepositorio = livroRepositorio;
	}
	
	@Override
	public List<Livro> listarTodos() {
		return livroRepositorio.findAll();
	}

	@Override
	public Livro buscarPorId(Long id) {
		return livroRepositorio.findById(id).orElseThrow();
	}

	@Override
	public Livro excluirPorId(Long id) {
		Livro livro = buscarPorId(id);
		livroRepositorio.deleteById(id);
		
		return livro;
	}

	@Override
	public List<Livro> buscarPorAutor(String autor) {
		return livroRepositorio.findByAutor(autor);
	}
	
	@Override
	public Livro salvar(Livro livro) {
		return livroRepositorio.save(livro);
	}
	
}
