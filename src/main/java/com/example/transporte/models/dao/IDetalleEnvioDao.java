package com.example.transporte.models.dao;

import com.example.transporte.models.entity.DetalleEnvio;
import org.springframework.data.repository.CrudRepository;

public interface IDetalleEnvioDao extends CrudRepository<DetalleEnvio, Long> {
}
