package com.example.transporte.models.services;

import com.example.transporte.models.entity.TipoDestino;

import java.util.List;

public interface ITipoDestinoService {

    public List<TipoDestino> findAll();

    public TipoDestino findByIdTipoDestino(Integer idTipoDestino);
}
