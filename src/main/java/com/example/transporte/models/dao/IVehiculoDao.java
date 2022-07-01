package com.example.transporte.models.dao;

import com.example.transporte.models.entity.Vehiculo;
import org.springframework.data.repository.CrudRepository;

public interface IVehiculoDao extends CrudRepository<Vehiculo, Integer> {
}
