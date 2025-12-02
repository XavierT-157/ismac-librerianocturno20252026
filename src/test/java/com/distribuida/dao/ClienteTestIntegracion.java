package com.distribuida.dao;

import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
//@Import(ClienteRepository.class)

public class ClienteTestIntegracion {
    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testClientFindAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        assertNotNull(clientes);
        assertTrue(clientes.size()>0);
        for (Cliente item : clientes){
            System.out.println(item.toString());
        }
    }

    @Test
    public void testClienteFindOne(){
        Optional<Cliente> cliente = clienteRepository.findById(1);
        assertNotNull(cliente.isPresent());
        assertEquals("Puro",cliente.orElse(null).getNombre());
        assertEquals("Hueso",cliente.orElse(null).getApellido());
        System.out.println(cliente);
    }

    @Test
    public void testClienteSave(){
        Cliente cliente = new Cliente(0, "1707712377", "Juan77", "Taipe77", "Av. 77", "0996906277", "jt77@correo.com");
        Cliente clienteGuardado = clienteRepository.save(cliente);

        assertNotNull(clienteGuardado);
        assertEquals("1707712377",clienteGuardado.getCedula());
        assertEquals("Juan77",clienteGuardado.getNombre());

    }

    @Test
    public void testClienteActualizar(){
        Optional<Cliente> cliente2 = clienteRepository.findById(35);

        assertTrue(cliente2.isPresent());

        cliente2.orElse(null).setCedula("1707287888");
        cliente2.orElse(null).setNombre("Juan88");
        cliente2.orElse(null).setApellido("Taipe88");
        cliente2.orElse(null).setDireccion("Avenida88");
        cliente2.orElse(null).setTelefono("0981234588");
        cliente2.orElse(null).setCorreo("jtaipe88@correo.com");

        Cliente clienteActualizado = clienteRepository.save(cliente2.orElse(null));

        assertNotNull(clienteActualizado);
        assertEquals("Taipe88", clienteActualizado.getApellido());
        assertEquals("Direccion88", clienteActualizado.getDireccion());

    }

    @Test
    public void testClienteBorrar() {
        if (clienteRepository.existsById(39)) {
            clienteRepository.deleteById(39);
        }
        assertFalse(clienteRepository.existsById(39));
    }

}