package com.example.auditoria.controller;

import com.example.auditoria.model.Autor;
import com.example.auditoria.model.Categoria;
import com.example.auditoria.service.CategoriaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/category")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<?> listCategories() {
        List<Categoria> categorias = categoriaService.listAll();
        log.info("Listar categorias");
        return new ResponseEntity<>(categorias, categorias.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCategories(@PathVariable("id") int id) {
        log.info("Obtener categorias: ", id);
        return new ResponseEntity<>(categoriaService.getCategoria(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> registerCategories(@Valid @RequestBody Categoria categoria) {
        log.info("Nuevo registro de categoria {}", categoria);
        return new ResponseEntity<Categoria>(categoriaService.createCategoria(categoria), HttpStatus.OK);
    }
}
