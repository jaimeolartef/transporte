package com.example.transporte.models.services;

import com.example.transporte.models.entity.DetalleEnvio;

import java.util.List;

public interface IDetalleEnvioService {

    public Iterable<DetalleEnvio> saveAll(Iterable<DetalleEnvio> detalleEnvios);
    public List<DetalleEnvio> findByIdEnvio(Integer idEnvio);
}
