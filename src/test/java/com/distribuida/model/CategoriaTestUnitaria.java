package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoriaTestUnitaria {

    private Categoria categoria;

    @BeforeEach
    public void setUp() {
        categoria = new Categoria(1, "Novela", "Libros narrativos de ficción");
    }

    @Test
    public void testCategoriaConstructor() {
        assertAll("Validar datos del constructor - Categoria",
                () -> assertEquals(1, categoria.getIdCategoria()),
                () -> assertEquals("Novela", categoria.getCategoria()),
                () -> assertEquals("Libros narrativos de ficción", categoria.getDescripcion())
        );
    }

    @Test
    public void testCategoriaSetters() {
        categoria.setIdCategoria(2);
        categoria.setCategoria("Ciencia");
        categoria.setDescripcion("Libros de divulgación científica");

        assertAll("Validar datos modificados - Categoria",
                () -> assertEquals(2, categoria.getIdCategoria()),
                () -> assertEquals("Ciencia", categoria.getCategoria()),
                () -> assertEquals("Libros de divulgación científica", categoria.getDescripcion())
        );
    }

    @Test
    public void testCategoriaToString() {
        String str = categoria.toString();
        assertAll("Validar contenido de toString - Categoria",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Novela")),
                () -> assertTrue(str.contains("Libros narrativos de ficción"))
        );
    }
}
