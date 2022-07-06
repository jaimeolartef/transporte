package com.example.transporte.models.dao;

import com.example.transporte.models.entity.DetalleEnvio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Stream;

public interface IDetalleEnvioDao extends CrudRepository<DetalleEnvio, Integer> {

    List<DetalleEnvio> findByIdEnvio(Integer idEnvio);

    void deleteByIdEnvio(Integer idEnvio);
}
