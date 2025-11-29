package com.distribuida.service;

import com.distribuida.dao.ClienteRepository;
import com.distribuida.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findOne(int id) {
        return null;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente update(Cliente cliente) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
