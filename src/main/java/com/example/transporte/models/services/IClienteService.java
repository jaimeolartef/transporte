package com.example.transporte.models.services;

import com.example.transporte.models.entity.Cliente;

import java.util.List;

public interface IClienteService {

    public Cliente findByIdCliente(Integer idCliente);

    public List<Cliente> findAll();

    public Cliente save(Cliente cliente);
}
