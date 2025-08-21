package com.edsonveiga.biblioteca_digital.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edsonveiga.biblioteca_digital.entity.Livro;

@Repository
public interface LivroRepositorio extends JpaRepository <Livro, Long> {

}
