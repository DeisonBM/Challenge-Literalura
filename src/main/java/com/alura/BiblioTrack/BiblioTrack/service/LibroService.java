package com.alura.BiblioTrack.BiblioTrack.service;

import com.alura.BiblioTrack.BiblioTrack.entity.Libro;
import com.alura.BiblioTrack.BiblioTrack.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        return libroRepository.findByTitulo(titulo);
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }

    public List<String> listarAutores() {
        return libroRepository.findAll()
                .stream()
                .map(Libro::getAutor)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Libro> listarAutoresVivosEnAnio(int anio) {
        return libroRepository.findAll()
                .stream()
                .filter(libro -> libro.isVivo() && libro.getAnio() == anio)
                .collect(Collectors.toList());
    }
}
