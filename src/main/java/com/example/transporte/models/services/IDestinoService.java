package com.example.transporte.models.services;

import com.example.transporte.models.entity.Destino;

import java.util.List;

public interface IDestinoService {

    public List<Destino> findAll();
    public Destino save(Destino destino);
    public void delete(Integer idDestino);
    public Destino findByIdDestino(Integer idDestino);
}
