package com.edsonveiga.biblioteca_digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edsonveiga.biblioteca_digital.entity.Usuario;
import com.edsonveiga.biblioteca_digital.repositorio.UsuarioRepositorio;
import com.edsonveiga.biblioteca_digital.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepositorio usuarioRepositorio;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioRepositorio usuarioRepositorio, PasswordEncoder passwordEncoder) {
		this.usuarioRepositorio = usuarioRepositorio;
		this.passwordEncoder = passwordEncoder;
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
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		return usuarioRepositorio.save(usuario);
	}
	
	@Override
	public Usuario buscarPorUsername(String userName) {
	    return usuarioRepositorio.findByUsername(userName)
	            .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + userName));
	}

}
