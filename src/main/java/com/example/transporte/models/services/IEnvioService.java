package com.example.transporte.models.services;

import com.example.transporte.models.entity.Envio;

import java.util.List;

public interface IEnvioService {

    public List<Envio> findAll();
}
