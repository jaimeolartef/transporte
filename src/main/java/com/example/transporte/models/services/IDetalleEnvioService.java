package com.example.transporte.models.services;

import com.example.transporte.models.entity.DetalleEnvio;

import java.util.List;

public interface IDetalleEnvioService {

    Iterable<DetalleEnvio> saveAll(Iterable<DetalleEnvio> detalleEnvios);
    List<DetalleEnvio> findByIdEnvio(Integer idEnvio);
    void delete(Integer idEnvio);
}
