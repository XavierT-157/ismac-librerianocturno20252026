package com.distribuida.dao;

import com.distribuida.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  //Esta es una anotación para hacer a la clase de tipo bean.
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    //public Cliente findCliente (int id);

}
