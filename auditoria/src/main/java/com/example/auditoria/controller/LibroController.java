package com.example.auditoria.controller;

import com.example.auditoria.model.Libro;
import com.example.auditoria.service.LibroService;
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
@RequestMapping("api/v1/product")
public class LibroController {

    private final LibroService libroService;

    @GetMapping
    public ResponseEntity<?> listProducts() {
        List<Libro> productos = libroService.listAll();
        log.info("Listar productos");
        return new ResponseEntity<>(productos, productos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long id) {
        log.info("Obtener productos: ", id);
        return new ResponseEntity<>(libroService.getLibro(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> registerProduct(@Valid @RequestBody Libro libro) {
        log.info("Nuevo registro de producto {}", libro);
        String result = libroService.validateLibro(libro);
        log.info("Resultado: " + result);
        if (result.equals("OK")) {
            return new ResponseEntity<Libro>(libroService.createLibro(libro), HttpStatus.OK);
        }
        return new ResponseEntity("Servicio validarProducto no disponible", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody Libro libro) {
        log.info("Modificar datos de producto {}", libro);
        return new ResponseEntity<Libro>(libroService.updateLibro(libro), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        log.info("Eliminar producto: ", id);
        return new ResponseEntity<>(libroService.deleteLibro(id), HttpStatus.OK);
    }
}
