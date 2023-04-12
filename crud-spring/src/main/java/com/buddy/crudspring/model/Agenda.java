package com.buddy.crudspring.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity

public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_idusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "animais_idanimal")
    private Animal animal;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "data_hora_inicial", nullable = false)
    private LocalDateTime dataHoraInicial;

    @Column(name = "data_hora_final", nullable = false)
    private LocalDateTime dataHoraFinal;s
}