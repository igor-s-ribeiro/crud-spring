package com.buddy.crudspring.controller;

import com.buddy.crudspring.model.Usuario;
import com.buddy.crudspring.repository.UsuarioRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
        Usuario usuario = usuarioRepository.findById(id.longValue()).orElse(null);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody @Valid Usuario usuario) {
        Usuario novoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Integer id, @RequestBody @Valid Usuario usuario) {
        if (!usuarioRepository.existsById(id.longValue())) {
            return ResponseEntity.notFound().build();
        }
        usuario.setIdUsuario(id);
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id) {
        if (!usuarioRepository.existsById(id.longValue())) {
            return ResponseEntity.notFound().build();
        }
        usuarioRepository.deleteById(id.longValue());
        return ResponseEntity.noContent().build();
    }
}
