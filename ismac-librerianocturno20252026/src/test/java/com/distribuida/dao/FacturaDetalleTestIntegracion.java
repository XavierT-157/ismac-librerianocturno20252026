package com.distribuida.dao;

import com.distribuida.model.FacturaDetalle;
import com.distribuida.model.Factura;
import com.distribuida.model.Libro;
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
public class FacturaDetalleTestIntegracion {

    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Test
    public void testFacturaDetalleFindAll() {
        List<FacturaDetalle> detalles = facturaDetalleRepository.findAll();
        assertNotNull(detalles);
        assertTrue(detalles.size() > 0);
        detalles.forEach(System.out::println);
    }

    @Test
    public void testFacturaDetalleFindOne() {
        Optional<FacturaDetalle> detalle = facturaDetalleRepository.findById(1);
        assertTrue(detalle.isPresent());
        assertEquals(2, detalle.orElse(null).getCantidad());
        System.out.println(detalle);
    }

    @Test
    public void testFacturaDetalleSave() {
        Optional<Factura> factura = facturaRepository.findById(1);
        Optional<Libro> libro = libroRepository.findById(1);

        assertTrue(factura.isPresent());
        assertTrue(libro.isPresent());

        FacturaDetalle detalle = new FacturaDetalle();
        detalle.setCantidad(3);
        detalle.setSubtotal(150.00);
        detalle.setFactura(factura.orElse(null));
        detalle.setLibro(libro.orElse(null));

        FacturaDetalle detalleGuardado = facturaDetalleRepository.save(detalle);
        assertNotNull(detalleGuardado);
        assertEquals(3, detalleGuardado.getCantidad());
    }

    @Test
    public void testFacturaDetalleUpdate() {
        Optional<FacturaDetalle> detalle = facturaDetalleRepository.findById(5);
        assertTrue(detalle.isPresent());

        detalle.orElse(null).setCantidad(10);
        detalle.orElse(null).setSubtotal(500.00);

        FacturaDetalle detalleActualizado = facturaDetalleRepository.save(detalle.orElse(null));
        assertNotNull(detalleActualizado);
        assertEquals(10, detalleActualizado.getCantidad());
    }

    @Test
    public void testFacturaDetalleDelete() {
        if (facturaDetalleRepository.existsById(7)) {
            facturaDetalleRepository.deleteById(7);
        }
        assertFalse(facturaDetalleRepository.existsById(7));
    }
}

