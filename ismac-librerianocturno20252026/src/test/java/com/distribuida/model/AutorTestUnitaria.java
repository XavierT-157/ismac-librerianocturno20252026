package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutorTestUnitaria {

    private Autor autor;

    @BeforeEach
    public void setUp() {
        autor = new Autor(1, "Gabriel", "García Márquez", "Colombia", "Calle Real 123", "0987654321", "gabriel@correo.com");
    }

    @Test
    public void testAutorConstructor() {
        assertAll("Validar datos del constructor - Autor",
                () -> assertEquals(1, autor.getIdAutor()),
                () -> assertEquals("Gabriel", autor.getNombre()),
                () -> assertEquals("García Márquez", autor.getApellido()),
                () -> assertEquals("Colombia", autor.getPais()),
                () -> assertEquals("Calle Real 123", autor.getDireccion()),
                () -> assertEquals("0987654321", autor.getTelefono()),
                () -> assertEquals("gabriel@correo.com", autor.getCorreo())
        );
    }

    @Test
    public void testAutorSetters() {
        autor.setIdAutor(2);
        autor.setNombre("Isabel");
        autor.setApellido("Allende");
        autor.setPais("Chile");
        autor.setDireccion("Avenida de los Sueños");
        autor.setTelefono("0999999999");
        autor.setCorreo("isabel@correo.com");

        assertAll("Validar datos modificados - Autor",
                () -> assertEquals(2, autor.getIdAutor()),
                () -> assertEquals("Isabel", autor.getNombre()),
                () -> assertEquals("Allende", autor.getApellido()),
                () -> assertEquals("Chile", autor.getPais()),
                () -> assertEquals("Avenida de los Sueños", autor.getDireccion()),
                () -> assertEquals("0999999999", autor.getTelefono()),
                () -> assertEquals("isabel@correo.com", autor.getCorreo())
        );
    }

    @Test
    public void testAutorToString() {
        String str = autor.toString();
        assertAll("Validar contenido de toString - Autor",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Gabriel")),
                () -> assertTrue(str.contains("García Márquez")),
                () -> assertTrue(str.contains("Colombia")),
                () -> assertTrue(str.contains("Calle Real 123")),
                () -> assertTrue(str.contains("0987654321")),
                () -> assertTrue(str.contains("gabriel@correo.com"))
        );
    }
}