package com.example.auditoria.service;

import com.example.auditoria.model.Autor;

import java.util.List;

public interface AutorService {

    public List<Autor> listAll();
    public Autor getAutor(int id);
    public Autor createAutor(Autor autor);

}
