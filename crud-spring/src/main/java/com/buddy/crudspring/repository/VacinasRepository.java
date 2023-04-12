package com.buddy.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buddy.crudspring.model.Vacinas;

import jakarta.validation.Valid;

public interface VacinasRepository extends JpaRepository<Vacinas, Long> {
    Vacinas saveAll(@Valid Vacinas course);
}