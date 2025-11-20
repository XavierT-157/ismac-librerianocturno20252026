package com.distribuida.dao;


import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)

public class ClienteTestIntegracion {
    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testClientFindAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        for (Cliente item : clientes){
            System.out.println(item.toString());
        }
    }

    @Test
    public void testClienteFindOne(){
        Optional<Cliente> cliente = clienteRepository.findById(1);
        System.out.println(cliente);
    }

    @Test
    public void testClienteSave(){
        Cliente cliente = new Cliente(0, "1707712377", "Juan77", "Taipe77", "Av. 77", "0996906277", "jt77@correo.com");
    clienteRepository.save(cliente);
    }

    @Test
    public void testClienteActualizar(){
        Optional<Cliente> cliente = clienteRepository.findById(39);

        cliente.orElse(null).setCedula("1707287888");
        cliente.orElse(null).setNombre("Juan88");
        cliente.orElse(null).setApellido("Taipe88");
        cliente.orElse(null).setDireccion("Avenida88");
        cliente.orElse(null).setTelefono("0981234588");
        cliente.orElse(null).setCorreo("jtaipe88@correo.com");

        clienteRepository.save(cliente.orElse(null));

    }

    @Test
    public void testClienteBorrar(){
        clienteRepository.deleteById(39);
    }
}
