package com.edsonveiga.biblioteca_digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edsonveiga.biblioteca_digital.entity.Usuario;
import com.edsonveiga.biblioteca_digital.repositorio.UsuarioRepositorio;
import com.edsonveiga.biblioteca_digital.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}
	@Override
	public List<Usuario> listarTodos() {
		return usuarioRepositorio.findAll();
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return usuarioRepositorio.findById(id).orElseThrow();
	}

	@Override
	public void excluirPorId(Long id) {
		usuarioRepositorio.deleteById(id);
	}

	@Override
	public Usuario salvar(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}

}
