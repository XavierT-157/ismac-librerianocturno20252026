package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTestUnitaria {

    private Cliente cliente;

    @BeforeEach
    public void setUp(){
        cliente = new Cliente(1, "17201234567", "Juan", "Taipe", "Direccion1", "0987654321", "jtaipe@correo.com" );

    }

    @Test
    public void testClienteConstructor(){
        assertAll("Validar datos cliente - Constructor",
                () -> assertEquals(1, cliente.getIdCliente()),
                () -> assertEquals("17201234567", cliente.getCedula()),
                () -> assertEquals("Juan", cliente.getNombre()),
                () -> assertEquals("Taipe", cliente.getApellido()),
                () -> assertEquals("Direccion1", cliente.getDireccion()),
                () -> assertEquals("0987654321", cliente.getTelefono()),
                () -> assertEquals("jtaipe@correo.com", cliente.getCorreo())
        );

    }

    @Test
    public void testClienteSetters(){
        cliente.setIdCliente(2);
        cliente.setCedula("1789321456");
        cliente.setNombre("Juanito");
        cliente.setApellido("Scotch");
        cliente.setDireccion("Direccion2");
        cliente.setTelefono("0987652222");
        cliente.setCorreo("jscotch@correo.com");

        assertAll("Validar datos cliente - Setters",
                () -> assertEquals(2, cliente.getIdCliente()),
                () -> assertEquals("1789321456", cliente.getCedula()),
                () -> assertEquals("Juanito", cliente.getNombre()),
                () -> assertEquals("Scotch", cliente.getApellido()),
                () -> assertEquals("Direccion2", cliente.getDireccion()),
                () -> assertEquals("0987652222", cliente.getTelefono()),
                () -> assertEquals("jscotch@correo.com", cliente.getCorreo())
        );

    }

    @Test
    public void ClienteTestToString(){
        String str = cliente.toString();
        assertAll("Validar datos cliente - ToString",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("17201234567")),
                () -> assertTrue(str.contains("Juan")),
                () -> assertTrue(str.contains("Taipe")),
                () -> assertTrue(str.contains("Direccion1")),
                () -> assertTrue(str.contains("0987654321")),
                () -> assertTrue(str.contains("jtaipe@correo.com"))
        );
    }



}
