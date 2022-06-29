package com.example.transporte.models.dao;

import com.example.transporte.models.entity.Envio;
import org.springframework.data.repository.CrudRepository;

public interface IEnvioDao extends CrudRepository<Envio, Long> {
}
