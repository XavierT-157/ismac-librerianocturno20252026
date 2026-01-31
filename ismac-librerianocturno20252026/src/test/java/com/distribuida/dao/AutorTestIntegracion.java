package com.distribuida.dao;

import com.distribuida.model.Autor;
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
public class AutorTestIntegracion {

    @Autowired
    private AutorRepository autorRepository;

    @Test
    public void testAutorFindAll() {
        List<Autor> autores = autorRepository.findAll();
        assertNotNull(autores);
        assertTrue(autores.size() > 0);
        autores.forEach(System.out::println);
    }

    @Test
    public void testAutorFindOne() {
        Optional<Autor> autor = autorRepository.findById(1);
        assertTrue(autor.isPresent());
        assertEquals("Miguel", autor.orElse(null).getNombre());
        assertEquals("Cervantes", autor.orElse(null).getApellido());
        System.out.println(autor);
    }

    @Test
    public void testAutorSave() {
        Autor autor = new Autor(0, "Gabriel", "García Márquez", "Colombia", "Calle Real", "0999999999", "gabriel@correo.com");
        Autor autorGuardado = autorRepository.save(autor);

        assertNotNull(autorGuardado);
        assertEquals("Gabriel", autorGuardado.getNombre());
        assertEquals("García Márquez", autorGuardado.getApellido());
    }

    @Test
    public void testAutorUpdate() {
        Optional<Autor> autor = autorRepository.findById(3);
        assertTrue(autor.isPresent());

        autor.orElse(null).setNombre("Julio");
        autor.orElse(null).setApellido("Cortázar");
        autor.orElse(null).setPais("Argentina");
        autor.orElse(null).setDireccion("Av. Libertador");
        autor.orElse(null).setTelefono("0987654321");
        autor.orElse(null).setCorreo("julio@correo.com");

        Autor autorActualizado = autorRepository.save(autor.orElse(null));
        assertNotNull(autorActualizado);
        assertEquals("Julio", autorActualizado.getNombre());
        assertEquals("Cortázar", autorActualizado.getApellido());
    }

    @Test
    public void testAutorDelete() {
        if (autorRepository.existsById(5)) {
            autorRepository.deleteById(5);
        }
        assertFalse(autorRepository.existsById(5));
    }
}
