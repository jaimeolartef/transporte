package com.example.transporte.models.services;

import com.example.transporte.models.entity.TipoProducto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface ITipoProductoService {

    public List<TipoProducto> findAll();
    public TipoProducto save(TipoProducto tipoProducto);
    public void delete(Integer idTipoProducto);
    public Optional<TipoProducto> findByIdTipoProducto(Integer idTipoProducto);
}
