package com.example.transporte.models.services;

import com.example.transporte.models.dao.ITipoProductoDao;
import com.example.transporte.models.entity.TipoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TipoProductoServiceImpl implements ITipoProductoService {

    @Autowired
    private ITipoProductoDao tipoProductoDao;

    @Override
    public List<TipoProducto> findAll() {
        return (List<TipoProducto>) tipoProductoDao.findAll();
    }

    @Override
    public TipoProducto save(TipoProducto tipoProducto) {
        return tipoProductoDao.save(tipoProducto);
    }

    @Override
    public void delete(Integer idTipoProducto) {
        tipoProductoDao.deleteById(idTipoProducto);
    }

    @Override
    public Optional<TipoProducto> findByIdTipoProducto(Integer idTipoProducto) {
        return tipoProductoDao.findById(idTipoProducto);
    }
}
