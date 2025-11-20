package com.distribuida.dao;

import com.distribuida.model.Factura;
import jakarta.transaction.Transactional;
import jdk.swing.interop.SwingInterOpUtils;
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

public class FacturaTestIntegracion {

    @Autowired
    private FacturaRepository facturaRepository;

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
}
