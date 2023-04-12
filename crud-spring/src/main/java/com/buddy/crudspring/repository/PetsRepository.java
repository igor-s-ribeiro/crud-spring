package com.buddy.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buddy.crudspring.model.Pets;

import jakarta.validation.Valid;

public interface PetsRepository extends JpaRepository<Pets, Long> {
    Pets saveAll(@Valid Pets course);
}