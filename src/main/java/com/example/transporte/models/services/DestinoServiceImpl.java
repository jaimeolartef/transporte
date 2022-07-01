package com.example.transporte.models.services;

import com.example.transporte.models.dao.IDestinoDao;
import com.example.transporte.models.entity.Destino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class DestinoServiceImpl implements  IDestinoService {

    @Autowired
    private IDestinoDao destinoDao;

    @Override
    public Destino save(Destino destino) {
        return destinoDao.save(destino);
    }

    @Override
    public List<Destino> findAll() {
        return (List<Destino>) destinoDao.findAll();
    }

    @Override
    public void delete(Integer idDestino) {
        destinoDao.deleteById(idDestino);
    }

    @Override
    public Destino findByIdDestino(Integer idDestino) {
        return destinoDao.findById(idDestino).get();
    }
}
