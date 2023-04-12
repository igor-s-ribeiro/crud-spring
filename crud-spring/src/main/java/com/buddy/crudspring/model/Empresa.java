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

public class Empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempresa", nullable = false, unique = true)
    private Integer idEmpresa;

    @Column(name = "nome_fantasia", nullable = false, length = 200)
    private String nomeFantasia;

    @Column(name = "razao_social", nullable = false, length = 200)
    private String razaoSocial;

    @Column(name = "cnpj", nullable = false)
    private Long cnpj;

    @Column(name = "inscricao_municipal")
    private Integer inscricaoMunicipal;

    @Column(name = "inscricao_estadual")
    private Integer inscricaoEstadual;

    @Column(name = "endereco", nullable = false, length = 150)
    private String endereco;

    @Column(name = "numero_endereco", nullable = false)
    private Integer numeroEndereco;

    @Column(name = "telefone", nullable = false)
    private Integer telefone;

    @Column(name = "cep", nullable = false)
    private Integer cep;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "email", nullable = false, length = 150, unique = true)
    private String email;
    
}