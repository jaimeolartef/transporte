package com.example.transporte.models.services;

import com.example.transporte.models.dao.IDestinoDao;
import com.example.transporte.models.dao.ITipoDestinoDao;
import com.example.transporte.models.entity.TipoDestino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDestinoServiceImpl implements ITipoDestinoService {

    @Autowired
    private ITipoDestinoDao tipoDestinoDao;

    @Override
    public List<TipoDestino> findAll() {
        return (List<TipoDestino>) tipoDestinoDao.findAll();
    }

    @Override
    public TipoDestino findByIdTipoDestino(Integer idTipoDestino) {
        return tipoDestinoDao.findById(idTipoDestino).get();
    }


}
