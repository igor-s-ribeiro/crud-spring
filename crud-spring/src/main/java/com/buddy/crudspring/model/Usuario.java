package com.buddy.crudspring.model;

import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Data

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idUsuario;

    @Column(name = "idtipo_usuario", nullable = false)
    private Integer idTipoUsuario;

    @Column(name = "oauth_provider", length = 45)
    private String oauthProvider;

    @Column(name = "oauth_id", length = 45)
    private String oauthId;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "senha", nullable = false, length = 100)
    private String senha;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

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

    public Object getCategory() {
        return null;
    }
}