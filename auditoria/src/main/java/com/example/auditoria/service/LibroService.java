package com.example.auditoria.service;

import com.example.auditoria.controller.LibroRequest;
import com.example.auditoria.model.Libro;

import java.util.List;

public interface LibroService {

    public List<Libro> listAll();
    public Libro createLibro(Libro libro);
    public String validateLibro(Libro libro);
    public Libro updateLibro(Libro libro);
    public Libro deleteLibro(long id);
    public Libro getLibro(long id);

}
