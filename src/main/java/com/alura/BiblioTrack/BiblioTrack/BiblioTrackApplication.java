package com.alura.BiblioTrack.BiblioTrack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alura.BiblioTrack.BiblioTrack.service.LibroService;
import com.alura.BiblioTrack.BiblioTrack.entity.Libro;

import java.util.Scanner;

@SpringBootApplication
public class BiblioTrackApplication implements CommandLineRunner {

    @Autowired
    private LibroService libroService;

    public static void main(String[] args) {
        SpringApplication.run(BiblioTrackApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar libros registrados");
            System.out.println("3. Listar autores registrados");
            System.out.println("4. Listar autores vivos en un determinado año");
            System.out.println("5. Listar libros por idioma");
            System.out.println("6. Salir");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    Libro libro = libroService.buscarLibroPorTitulo(titulo);
                    System.out.println(libro);
                    break;
                case 2:
                    libroService.listarLibros().forEach(System.out::println);
                    break;
                case 3:
                    libroService.listarAutores().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Ingrese el año: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    libroService.listarAutoresVivosEnAnio(anio).forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Ingrese el idioma: ");
                    String idioma = scanner.nextLine();
                    libroService.listarLibrosPorIdioma(idioma).forEach(System.out::println);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

        scanner.close();
    }
}
