package com.example.auditoria.repository;

import com.example.auditoria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro,Long> {

    Libro findBySerie(String serie);
}
