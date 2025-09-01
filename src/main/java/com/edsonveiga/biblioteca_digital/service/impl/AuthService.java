package com.edsonveiga.biblioteca_digital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.edsonveiga.biblioteca_digital.entity.Usuario;
import com.edsonveiga.biblioteca_digital.repositorio.UsuarioRepositorio;

public class AuthService implements UserDetailsService {

	private final UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	public AuthService(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        return User
                .withUsername(usuario.getUsername())
                .password(usuario.getSenha())
                .roles(usuario.getRole().name())
                .build();
	}
}
