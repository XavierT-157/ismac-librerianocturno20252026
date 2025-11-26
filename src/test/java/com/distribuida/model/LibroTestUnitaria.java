package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LibroTestUnitaria {

    private Libro libro;
    private Categoria categoria;
    private Autor autor;

    @BeforeEach
    public void setUp() {
        categoria = new Categoria(1, "Novela", "Narrativa de ficción");
        autor = new Autor(1, "Gabriel", "García Márquez", "Colombia", "Calle Real 123", "0987654321", "gabriel@correo.com");

        libro = new Libro(1, "Cien Años de Soledad", "Sudamericana", 471, "Primera", "Español",
                new Date(), "Obra maestra del realismo mágico", "Dura", "ISBN12345", 100,
                "Portada Amarilla", "Tapa dura", 25.50, categoria, autor);
    }

    @Test
    public void testLibroConstructor() {
        assertAll("Validar datos del constructor - Libro",
                () -> assertEquals(1, libro.getIdLibro()),
                () -> assertEquals("Cien Años de Soledad", libro.getTitulo()),
                () -> assertEquals("Sudamericana", libro.getEditorial()),
                () -> assertEquals(471, libro.getNumPaginas()),
                () -> assertEquals("Primera", libro.getEdicion()),
                () -> assertEquals("Español", libro.getIdioma()),
                () -> assertEquals("Novela", libro.getCategoria().getCategoria()),
                () -> assertEquals("Gabriel", libro.getAutor().getNombre())
        );
    }

    @Test
    public void testLibroSetters() {
        libro.setIdLibro(2);
        libro.setTitulo("La Casa de los Espíritus");
        libro.setEditorial("Plaza & Janés");
        libro.setNumPaginas(400);
        libro.setEdicion("Segunda");
        libro.setIdioma("Español");
        libro.setPrecio(30.00);

        assertAll("Validar datos modificados - Libro",
                () -> assertEquals(2, libro.getIdLibro()),
                () -> assertEquals("La Casa de los Espíritus", libro.getTitulo()),
                () -> assertEquals("Plaza & Janés", libro.getEditorial()),
                () -> assertEquals(400, libro.getNumPaginas()),
                () -> assertEquals("Segunda", libro.getEdicion()),
                () -> assertEquals("Español", libro.getIdioma()),
                () -> assertEquals(30.00, libro.getPrecio())
        );
    }

    @Test
    public void testLibroToString() {
        String str = libro.toString();
        assertAll("Validar contenido de toString - Libro",
                () -> assertTrue(str.contains("Cien Años de Soledad")),
                () -> assertTrue(str.contains("Sudamericana")),
                () -> assertTrue(str.contains("471")),
                () -> assertTrue(str.contains("Novela")),
                () -> assertTrue(str.contains("Gabriel"))
        );
    }
}

