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
import java.time.LocalDate;


@Data
@Entity

public class Pets {

    @Id
    @Column(name = "idanimal", nullable = false, unique = true)
    private Integer idAnimal;

    @Column(name = "idusuario", nullable = false, unique = true)
    private Integer idUsuario;

    @Column(name = "idade", nullable = false, precision = 3, scale = 0)
    private Integer idade;

    @Column(name = "raca", nullable = false, length = 100)
    private String raca;

    @Column(name = "nomedoanimal", nullable = false, length = 150)
    private String nomeDoAnimal;

    @Column(name = "especie", nullable = false, length = 150)
    private String especie;

    @Column(name = "cor", nullable = false, length = 45)
    private String cor;

    @Column(name = "datanascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "dataaquisicao", nullable = false)
    private LocalDate dataAquisicao;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

}