package com.example.transporte.models.services;

import com.example.transporte.models.entity.Envio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface IEnvioService {

    public List<Envio> findAll();
    public Envio save(Envio envio);
    public void delete(Integer idEnvio);
    public Optional<Envio> findByIdEnvio(Integer idEnvio);


}
