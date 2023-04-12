package com.buddy.crudspring.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.buddy.crudspring.model.Pets;
import com.buddy.crudspring.repository.PetsRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/Pets")

public class PetsController {

    private final PetsRepository petsRepository;

    public PetsController(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    @GetMapping
    public @ResponseBody List<Pets> list() {
        return petsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pets> findById(@PathVariable @NotNull @Positive Long id) {
        return petsRepository.findById(id)
                .map(recordFound -> ResponseEntity.ok().body(recordFound))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Pets create(@RequestBody @Valid Pets course) {
        return petsRepository.saveAll(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pets> update(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid Pets pets) {
        return petsRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setIdAnimal(pets.getIdAnimal());
                    recordFound.setNomeDoAnimal(pets.getNomeDoAnimal());
                    Pets updated = petsRepository.save(recordFound);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @NotNull @Positive Long id) {
        return petsRepository.findById(id)
                .map(recordFound -> {
                    petsRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}