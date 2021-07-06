package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.service.CategoriaUsuarioService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/categoriausuario")
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaUsuarioController {

    @Autowired
    CategoriaUsuarioService service;

    @GetMapping
    public ResponseEntity<List<CategoriaUsuario>> getAllCategoriaUsuario(){
        return ResponseEntity.ok(service.listAllCategoriaUsuario());
    }

    @PostMapping
    public ResponseEntity<CategoriaUsuario> saveCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario) {
        categoriaUsuario = service.saveCategoriaUsuario(categoriaUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaUsuario> getCategoriaUsuario(@PathVariable Long id) {

        var categoriaUsuario = service.getCategoriaUsuarioById(id);
        if (categoriaUsuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoriaUsuario.get());

    }
}
