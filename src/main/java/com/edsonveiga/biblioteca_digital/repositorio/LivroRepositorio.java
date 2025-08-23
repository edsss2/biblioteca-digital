package com.edsonveiga.biblioteca_digital.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edsonveiga.biblioteca_digital.entity.Livro;

@Repository
public interface LivroRepositorio extends JpaRepository <Livro, Long> {

	public List<Livro> findByAutor(String autor);
}
