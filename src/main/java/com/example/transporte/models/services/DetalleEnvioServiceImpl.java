package com.example.transporte.models.services;

import com.example.transporte.models.dao.IDetalleEnvioDao;
import com.example.transporte.models.entity.DetalleEnvio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleEnvioServiceImpl implements IDetalleEnvioService {

    @Autowired
    private IDetalleEnvioDao detalleEnvioDao;

    @Override
    public Iterable<DetalleEnvio> saveAll(Iterable<DetalleEnvio> detalleEnvios) {
        return detalleEnvioDao.saveAll(detalleEnvios);
    }

    @Override
    public List<DetalleEnvio> findByIdEnvio(Integer idEnvio) {
        return detalleEnvioDao.findByIdEnvio(idEnvio);
    }

    @Transactional
    @Override
    public void delete(Integer idEnvio) {
        detalleEnvioDao.deleteByIdEnvio(idEnvio);
    }
}
