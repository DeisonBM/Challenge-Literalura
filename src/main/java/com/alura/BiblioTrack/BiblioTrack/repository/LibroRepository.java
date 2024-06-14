package com.alura.BiblioTrack.BiblioTrack.repository;

import com.alura.BiblioTrack.BiblioTrack.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Libro findByTitulo(String titulo);
    List<Libro> findByIdioma(String idioma);
    List<Libro> findByAutorAndVivo(String autor, boolean vivo);
    List<Libro> findByAutor(String autor);
}
