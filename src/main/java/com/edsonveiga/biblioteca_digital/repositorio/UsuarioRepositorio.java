package com.edsonveiga.biblioteca_digital.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edsonveiga.biblioteca_digital.entity.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByUsername(String username);
}
