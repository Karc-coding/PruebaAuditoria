package com.example.auditoria.service.impl;

import com.example.auditoria.model.Categoria;
import com.example.auditoria.repository.CategoriaRepository;
import com.example.auditoria.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaRepository repo;

    @Override
    public List<Categoria> listAll() {
        return repo.findAll();
    }

    @Override
    public Categoria getCategoria(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Categoria createCategoria(Categoria categoria) {
        return repo.save(categoria);
    }
}
