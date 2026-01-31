package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FacturaDetalleTestUnitaria {

    private FacturaDetalle facturaDetalle;
    private Factura factura;
    private Libro libro;

    @BeforeEach
    public void setUp() {
        // Simulación de objetos relacionados
        factura = new Factura();
        factura.setIdFactura(1);
        factura.setNumFactura("FAC-0001");
        factura.setFecha(new Date());
        factura.setTotalNeto(50.00);
        factura.setIva(7.50);
        factura.setTotal(57.50);

        libro = new Libro();
        libro.setIdLibro(1);
        libro.setTitulo("Cien Años de Soledad");
        libro.setEditorial("Sudamericana");
        libro.setNumPaginas(471);
        libro.setPrecio(25.00);

        facturaDetalle = new FacturaDetalle(1, 2, 50.00, factura, libro);
    }

    @Test
    public void testFacturaDetalleConstructor() {
        assertAll("Validar datos del constructor - FacturaDetalle",
                () -> assertEquals(1, facturaDetalle.getIdFacturaDetalle()),
                () -> assertEquals(2, facturaDetalle.getCantidad()),
                () -> assertEquals(50.00, facturaDetalle.getSubtotal()),
                () -> assertEquals("FAC-0001", facturaDetalle.getFactura().getNumFactura()),
                () -> assertEquals("Cien Años de Soledad", facturaDetalle.getLibro().getTitulo())
        );
    }

    @Test
    public void testFacturaDetalleSetters() {
        facturaDetalle.setIdFacturaDetalle(2);
        facturaDetalle.setCantidad(3);
        facturaDetalle.setSubtotal(75.00);

        assertAll("Validar datos modificados - FacturaDetalle",
                () -> assertEquals(2, facturaDetalle.getIdFacturaDetalle()),
                () -> assertEquals(3, facturaDetalle.getCantidad()),
                () -> assertEquals(75.00, facturaDetalle.getSubtotal())
        );
    }

    @Test
    public void testFacturaDetalleToString() {
        String str = facturaDetalle.toString();
        assertAll("Validar contenido de toString - FacturaDetalle",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("2")),
                () -> assertTrue(str.contains("50.0")),
                () -> assertTrue(str.contains("FAC-0001")),
                () -> assertTrue(str.contains("Cien Años de Soledad"))
        );
    }
}
