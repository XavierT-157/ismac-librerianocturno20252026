package com.distribuida.controller;

import com.distribuida.model.Factura;
import com.distribuida.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public ResponseEntity<List<Factura>> findAll(){
        List<Factura> facturas = facturaService.findAll();
        return ResponseEntity.ok(facturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> findOne(@PathVariable int id){
        Factura factura = facturaService.findOne(id);
        if (factura == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(factura);
    }
}
