package com.example.auditoria.service;

import com.example.auditoria.model.Categoria;

import java.util.List;

public interface CategoriaService {

    public List<Categoria> listAll();
    public Categoria getCategoria(int id);
    public Categoria createCategoria(Categoria categoria);

}
