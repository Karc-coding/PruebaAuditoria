package com.example.auditoria.service.impl;

import com.example.auditoria.model.Autor;
import com.example.auditoria.repository.AutorRepository;
import com.example.auditoria.service.AutorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AutorServiceImpl implements AutorService {

    private AutorRepository repo;

    @Override
    public List<Autor> listAll() {
        return repo.findAll();
    }

    @Override
    public Autor getAutor(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Autor createAutor(Autor autor) {
        return repo.save(autor);
    }
}
