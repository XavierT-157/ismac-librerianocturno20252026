package com.distribuida.dao;

import com.distribuida.model.Categoria;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class CategoriaTestIntegracion {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void testCategoriaFindAll() {
        List<Categoria> categorias = categoriaRepository.findAll();
        assertNotNull(categorias);
        assertTrue(categorias.size() > 0);
        categorias.forEach(System.out::println);
    }

    @Test
    public void testCategoriaFindOne() {
        Optional<Categoria> categoria = categoriaRepository.findById(1);
        assertTrue(categoria.isPresent());
        assertEquals("Novela", categoria.orElse(null).getCategoria());
        System.out.println(categoria);
    }

    @Test
    public void testCategoriaSave() {
        Categoria categoria = new Categoria(0, "Ciencia Ficción", "Libros de ciencia ficción");
        Categoria categoriaGuardada = categoriaRepository.save(categoria);

        assertNotNull(categoriaGuardada);
        assertEquals("Ciencia Ficción", categoriaGuardada.getCategoria());
        assertEquals("Libros de ciencia ficción", categoriaGuardada.getDescripcion());
    }

    @Test
    public void testCategoriaUpdate() {
        Optional<Categoria> categoria = categoriaRepository.findById(3);
        assertTrue(categoria.isPresent());

        categoria.orElse(null).setCategoria("Historia");
        categoria.orElse(null).setDescripcion("Libros históricos");

        Categoria categoriaActualizada = categoriaRepository.save(categoria.orElse(null));
        assertNotNull(categoriaActualizada);
        assertEquals("Historia", categoriaActualizada.getCategoria());
    }

    @Test
    public void testCategoriaDelete() {
        if (categoriaRepository.existsById(5)) {
            categoriaRepository.deleteById(5);
        }
        assertFalse(categoriaRepository.existsById(5));
    }
}
