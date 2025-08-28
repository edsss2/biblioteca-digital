package com.edsonveiga.biblioteca_digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsonveiga.biblioteca_digital.entity.Usuario;
import com.edsonveiga.biblioteca_digital.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuarios() {
		return ResponseEntity.ok(usuarioService.listarTodos());
	}
	
	@GetMapping("/{id}/usuario")
	public ResponseEntity<Usuario> getUsuarioById(Long id) {
		return ResponseEntity.ok(usuarioService.buscarPorId(id));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Usuario> salvar(@Valid @RequestBody Usuario usuario) {
		return new ResponseEntity<>(usuarioService.salvar(usuario), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}/deletar")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		usuarioService.excluirPorId(id);
		return ResponseEntity.noContent().build();
	}
}
