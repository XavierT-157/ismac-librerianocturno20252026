package com.distribuida.dao;

import com.distribuida.model.Cliente;
import com.distribuida.model.Factura;
import jakarta.transaction.Transactional;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)

public class FacturaTestIntegracion {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testFacturaFindAll(){
        List<Factura> facturas = facturaRepository.findAll();
        facturas.forEach(System.out::println);
    }

    @Test
    public void testFacturaFindOne(){
        Optional<Factura> factura = facturaRepository.findById(1);

        System.out.println(factura);

    }

    @Test
    public void testFacturaSave(){
        Optional<Cliente> cliente = clienteRepository.findById(1);

        Factura factura = new Factura();
        factura.setIdFactura(0);
        factura.setNumFactura("FAC-00066");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.00);
        factura.setIva(15.00);
        factura.setTotal(115.00);
        factura.setCliente(cliente.orElse(null));

        facturaRepository.save(factura);
    }

    @Test
    public void testFacturaUpdate(){
        Optional<Cliente> cliente = clienteRepository.findById(2);
        Optional<Factura> factura = facturaRepository.findById(82);

        factura.orElse(null).setNumFactura("FAC-00077");
        factura.orElse(null).setFecha(new Date());
        factura.orElse(null).setTotalNeto(200.00);
        factura.orElse(null).setIva(60.00);
        factura.orElse(null).setTotal(260.00);
        factura.orElse(null).setCliente(cliente.orElse(null));

        facturaRepository.save(factura.orElse(null));

    }

    @Test
    public void testFacturaDelete(){
        facturaRepository.deleteById(90);
    }
}
