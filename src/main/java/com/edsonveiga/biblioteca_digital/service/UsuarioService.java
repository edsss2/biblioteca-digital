package com.edsonveiga.biblioteca_digital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edsonveiga.biblioteca_digital.entity.Usuario;

@Service
public interface UsuarioService {

	List<Usuario> listarTodos();
	Usuario buscarPorId(Long id);
	Usuario buscarPorUsername(String username);
	void excluirPorId(Long id);
	Usuario salvar(Usuario usuario);
	
}
