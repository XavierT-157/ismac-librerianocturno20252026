package com.distribuida.dao;

import com.distribuida.model.Libro;
import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class LibroTestIntegracion {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void testLibroFindAll() {
        List<Libro> libros = libroRepository.findAll();
        assertNotNull(libros);
        assertTrue(libros.size() > 0);
        libros.forEach(System.out::println);
    }

    @Test
    public void testLibroFindOne() {
        Optional<Libro> libro = libroRepository.findById(1);
        assertTrue(libro.isPresent());
        assertEquals("El Quijote", libro.orElse(null).getTitulo());
        System.out.println(libro);
    }

    @Test
    public void testLibroSave() {
        Optional<Autor> autor = autorRepository.findById(1);
        Optional<Categoria> categoria = categoriaRepository.findById(1);

        assertTrue(autor.isPresent());
        assertTrue(categoria.isPresent());

        Libro libro = new Libro();
        libro.setIdLibro(0);
        libro.setTitulo("Nuevo Libro");
        libro.setEditorial("Editorial Ejemplo");
        libro.setNumPaginas(200);
        libro.setEdicion("Primera");
        libro.setIdioma("Español");
        libro.setFechaPublicacion(new Date());
        libro.setDescripcion("Un libro de prueba");
        libro.setTipoPasta("Dura");
        libro.setISBN("ISBN-12345");
        libro.setNumEjemplares(10);
        libro.setPortada("Portada.jpg");
        libro.setPresentacion("Presentación estándar");
        libro.setPrecio(25.50);
        libro.setAutor(autor.orElse(null));
        libro.setCategoria(categoria.orElse(null));

        Libro libroGuardado = libroRepository.save(libro);
        assertNotNull(libroGuardado);
        assertEquals("Nuevo Libro", libroGuardado.getTitulo());
    }

    @Test
    public void testLibroUpdate() {
        Optional<Libro> libro = libroRepository.findById(5);
        assertTrue(libro.isPresent());

        libro.orElse(null).setTitulo("Libro Actualizado");
        libro.orElse(null).setPrecio(30.00);

        Libro libroActualizado = libroRepository.save(libro.orElse(null));
        assertNotNull(libroActualizado);
        assertEquals("Libro Actualizado", libroActualizado.getTitulo());
        assertEquals(30.00, libroActualizado.getPrecio());
    }

    @Test
    public void testLibroDelete() {
        if (libroRepository.existsById(7)) {
            libroRepository.deleteById(7);
        }
        assertFalse(libroRepository.existsById(7));
    }
}

