package com.dio.live.service;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.repository.CategoriaUsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaUsuarioService {

    @Autowired
    private CategoriaUsuarioRepository repository;

    public CategoriaUsuario saveCategoriaUsuario(CategoriaUsuario categoriaUsuario) {
        return repository.save(categoriaUsuario);
    }

    public List<CategoriaUsuario> listAllCategoriaUsuario() {
        return repository.findAll();
    }

    public Optional<CategoriaUsuario> getCategoriaUsuarioById(Long id) {
        return repository.findById(id);
    }
}
