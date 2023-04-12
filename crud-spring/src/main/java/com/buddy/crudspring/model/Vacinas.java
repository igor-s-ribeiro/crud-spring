package com.buddy.crudspring.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity

public class Vacinas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtratamento")
    private Integer idTratamento;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "medicamento", nullable = false, length = 150)
    private String medicamento;

    @Column(name = "peso")
    private Integer peso;

    @Column(name = "dose")
    private Integer dose;

    @Column(name = "revacinarem")
    private LocalDate revacinarem;

    @Column(name = "medicoresponsavel", length = 150)
    private String medicoResponsavel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animais_idanimal", nullable = false, referencedColumnName = "idanimal", unique = true)
    private String animal;
}