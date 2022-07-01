package com.example.transporte.models.services;

import com.example.transporte.models.entity.Ciudad;
import com.example.transporte.models.entity.Destino;

import java.util.List;

public interface ICiudadService {
    public List<Ciudad> findAll();

    public Ciudad findByIdCiudad(Integer idCiudad);

}
