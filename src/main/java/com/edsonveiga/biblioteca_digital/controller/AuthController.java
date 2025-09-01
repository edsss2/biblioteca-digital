package com.edsonveiga.biblioteca_digital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsonveiga.biblioteca_digital.service.UsuarioService;
import com.edsonveiga.biblioteca_digital.service.impl.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final UsuarioService usuarioService;
	private final AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService, UsuarioService usuarioService) {
		this.authService = authService;
		this.usuarioService = usuarioService;
	}
	
}
