package com.example.transporte.models.services;

import com.example.transporte.models.dao.IDestinoDao;
import com.example.transporte.models.entity.Destino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinoServiceImpl implements  IDestinoService {

    @Autowired
    private IDestinoDao destinoDao;

    @Override
    public Destino guardar(Destino destino) {
        return destinoDao.save(destino);
    }
}
