package com.example.transporte.models.dao;

import com.example.transporte.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Integer> {
}
