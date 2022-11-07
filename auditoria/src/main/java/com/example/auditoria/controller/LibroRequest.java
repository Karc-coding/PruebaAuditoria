package com.example.auditoria.controller;

import com.example.auditoria.model.Autor;
import com.example.auditoria.model.Categoria;

public record LibroRequest(Long id, String title, String serie, String yearBook, Categoria categoria, Double price, Integer stock,Autor autor) {
}
