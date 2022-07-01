package com.example.transporte.models.services;

import com.example.transporte.models.dao.IVehiculoDao;
import com.example.transporte.models.entity.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private IVehiculoDao vehiculoDao;

    @Override
    public Vehiculo findById(Integer idVehiculo) {
        return vehiculoDao.findById(idVehiculo).get();
    }
}
