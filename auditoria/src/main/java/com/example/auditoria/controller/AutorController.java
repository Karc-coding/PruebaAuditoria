package com.example.auditoria.controller;

import com.example.auditoria.model.Autor;
import com.example.auditoria.model.Libro;
import com.example.auditoria.service.AutorService;
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
@RequestMapping("api/v1/author")
public class AutorController {

    private final AutorService autorService;

    @GetMapping
    public ResponseEntity<?> listAuthors() {
        List<Autor> autores = autorService.listAll();
        log.info("Listar autores");
        return new ResponseEntity<>(autores, autores.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAuthors(@PathVariable("id") int id) {
        log.info("Obtener autores: ", id);
        return new ResponseEntity<>(autorService.getAutor(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> registerAuthors(@Valid @RequestBody Autor autor) {
        log.info("Nuevo registro de autor {}", autor);
        return new ResponseEntity<Autor>(autorService.createAutor(autor), HttpStatus.OK);
    }
}
