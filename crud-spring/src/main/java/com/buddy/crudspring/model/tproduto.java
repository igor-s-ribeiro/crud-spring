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

public class tproduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprodutos")
    private int idprodutos;

    @Column(name = "nomefantasia", nullable = false, length = 250)
    private String nomefantasia;

    @Column(name = "descricao", length = 500)
    private String descricao;

    @Column(name = "peso", precision = 10, scale = 3)
    private BigDecimal peso;

    @Column(name = "preco_venda", precision = 10, scale = 3)
    private BigDecimal precoVenda;

    @Column(name = "preco_custo", precision = 10, scale = 3)
    private BigDecimal precoCusto;

    @Column(name = "desconto", precision = 10, scale = 3)
    private BigDecimal desconto;

    @Column(name = "marca", length = 100)
    private String marca;

    @Column(name = "gtin", nullable = false)
    private long gtin;
}