package com.edsonveiga.biblioteca_digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsonveiga.biblioteca_digital.entity.Livro;
import com.edsonveiga.biblioteca_digital.service.LivroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

	private final LivroService livroService;
	
	@Autowired
	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<Livro>> getLivros() {
		return ResponseEntity.ok(livroService.listarTodos());
	}
	
	@GetMapping("/{autor}/livros")
	public ResponseEntity<List<Livro>> getLivrosByAutor(@PathVariable String autor) {
		return ResponseEntity.ok(livroService.buscarPorAutor(autor));
	}
	
	@GetMapping("/{id}/livro")
	public ResponseEntity<Livro> getLivroById(@PathVariable Long id) {
		return ResponseEntity.ok(livroService.buscarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Livro> salvar(@Valid @RequestBody Livro livro) {
		return new ResponseEntity<>(livroService.salvar(livro), HttpStatus.CREATED);
	}
	
}
