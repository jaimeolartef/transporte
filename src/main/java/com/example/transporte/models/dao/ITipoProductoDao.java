package com.example.transporte.models.dao;

import com.example.transporte.models.entity.TipoProducto;
import org.springframework.data.repository.CrudRepository;

public interface ITipoProductoDao extends CrudRepository<TipoProducto, Long> {
}
