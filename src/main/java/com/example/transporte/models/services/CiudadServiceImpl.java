package com.example.transporte.models.services;


import com.example.transporte.models.dao.ICiudadDao;
import com.example.transporte.models.entity.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServiceImpl implements  ICiudadService {

    @Autowired
    private ICiudadDao ciudadDao;

    @Override
    public List<Ciudad> findAll() {
        return (List<Ciudad>) ciudadDao.findAll();
    }

    @Override
    public Ciudad findByIdCiudad(Integer idCiudad) {
        return ciudadDao.findById(idCiudad).get();
    }
}
