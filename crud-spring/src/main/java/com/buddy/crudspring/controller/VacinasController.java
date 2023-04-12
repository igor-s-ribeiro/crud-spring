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

import com.buddy.crudspring.model.Vacinas;
import com.buddy.crudspring.repository.VacinasRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/courses")

public class VacinasController {

    private final VacinasRepository vacinasRepository;

    public VacinasController(VacinasRepository vacinasRepository) {
        this.vacinasRepository = vacinasRepository;
    }

    @GetMapping
    public @ResponseBody List<Vacinas> list() {
        return vacinasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacinas> findById(@PathVariable @NotNull @Positive Long id) {
        return vacinasRepository.findById(id)
                .map(recordFound -> ResponseEntity.ok().body(recordFound))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Vacinas create(@RequestBody @Valid Vacinas course) {
        return vacinasRepository.saveAll(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vacinas> update(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid Vacinas vacinas) {
        return vacinasRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(vacinas.getName());
                    recordFound.setCategory(vacinas.getCategory());
                    Vacinas updated = vacinasRepository.save(recordFound);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @NotNull @Positive Long id) {
        return vacinasRepository.findById(id)
                .map(recordFound -> {
                    vacinasRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}