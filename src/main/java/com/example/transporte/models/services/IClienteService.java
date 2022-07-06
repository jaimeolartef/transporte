package com.example.transporte.models.services;

import com.example.transporte.models.entity.Cliente;

import java.util.List;

public interface IClienteService {

    Cliente findByIdCliente(Integer idCliente);

    List<Cliente> findAll();

    Cliente save(Cliente cliente);

    void delete(Integer idCliente);
}
