package com.example.transporte.models.services;

import com.example.transporte.models.dao.IClienteDao;
import com.example.transporte.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServceImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Override
    public Cliente findByIdCliente(Integer idCliente) {
        return clienteDao.findById(idCliente).get();
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }
    @Override
    public void delete(Integer idCliente) {
        clienteDao.deleteById(idCliente);
    }
}
