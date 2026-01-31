package com.distribuida.service;

import com.distribuida.dao.FacturaDetalleRepository;
import com.distribuida.model.FacturaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaDetalleServiceImpl implements FacturaDetalleService {

    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;

    @Override
    public List<FacturaDetalle> findAll() {
        return facturaDetalleRepository.findAll();
    }

    @Override
    public FacturaDetalle findOne(int id) {
        return facturaDetalleRepository.findById(id).orElse(null);
    }

    @Override
    public FacturaDetalle save(FacturaDetalle facturaDetalle) {
        return facturaDetalleRepository.save(facturaDetalle);
    }

    @Override
    public FacturaDetalle update(int id, FacturaDetalle facturaDetalle) {
        Optional<FacturaDetalle> detalleExistente = facturaDetalleRepository.findById(id);

        if (detalleExistente == null) {
            return null;
        }

        detalleExistente.orElse(null).setCantidad(facturaDetalle.getCantidad());
        detalleExistente.orElse(null).setSubtotal(facturaDetalle.getSubtotal());
        detalleExistente.orElse(null).setFactura(facturaDetalle.getFactura());
        detalleExistente.orElse(null).setLibro(facturaDetalle.getLibro());

        return facturaDetalleRepository.save(detalleExistente.orElse(null));
    }

    @Override
    public void delete(int id) {
        if (facturaDetalleRepository.existsById(id)) {
            facturaDetalleRepository.deleteById(id);
        }
    }
}
