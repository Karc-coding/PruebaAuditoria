package com.example.auditoria.service.impl;

import com.example.auditoria.controller.LibroRequest;
import com.example.auditoria.model.Libro;
import com.example.auditoria.repository.LibroRepository;
import com.example.auditoria.service.LibroService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class LibroServiceImpl implements LibroService {

    private LibroRepository repo;

    @Override
    public List<Libro> listAll() {
        return repo.findAll();
    }

    @Override
    public Libro createLibro(Libro libro) {
        return repo.save(libro);
    }

    public String validateLibro(Libro libro) {
        boolean validacion = repo.findBySerie(libro.getSerie()) != null ? true : false;
        if (validacion){
            throw new IllegalStateException("El libro ya existe!!");
        }
        return "OK";
    }

    @Override
    public Libro updateLibro(Libro libro) {
        Libro book = getLibro(libro.getId());
        if (book == null)
            return null;

        libro.setCreatedDate(book.getCreatedDate());
        return repo.save(libro);
    }

    @Override
    public Libro deleteLibro(long id) {
        Libro book = getLibro(id);
        if (book == null)
            return null;
        repo.deleteById(id);
        return book;
    }

    @Override
    public Libro getLibro(long id) {
        return repo.findById(id).orElse(null);
    }
}
