package com.distribuida.service;

import com.distribuida.dao.FacturaDetalleRepository;
import com.distribuida.model.FacturaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public FacturaDetalle update(FacturaDetalle facturaDetalle) {
        FacturaDetalle detalleExistente = facturaDetalleRepository.findById(facturaDetalle.getIdFacturaDetalle()).orElse(null);

        if (detalleExistente == null) {
            return null;
        }

        detalleExistente.setCantidad(facturaDetalle.getCantidad());
        detalleExistente.setSubtotal(facturaDetalle.getSubtotal());
        detalleExistente.setFactura(facturaDetalle.getFactura());
        detalleExistente.setLibro(facturaDetalle.getLibro());

        return facturaDetalleRepository.save(detalleExistente);
    }

    @Override
    public void delete(int id) {
        if (facturaDetalleRepository.existsById(id)) {
            facturaDetalleRepository.deleteById(id);
        }
    }
}
