package com.buddy.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buddy.crudspring.model.Usuario;

import jakarta.validation.Valid;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario saveAll(@Valid Usuario course);
}