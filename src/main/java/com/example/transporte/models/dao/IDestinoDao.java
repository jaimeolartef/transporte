package com.example.transporte.models.dao;

import com.example.transporte.models.entity.Destino;
import org.springframework.data.repository.CrudRepository;

public interface IDestinoDao extends CrudRepository<Destino, Integer> {

    public Destino findByIdDestino(Integer idDestino);
}
