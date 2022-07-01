package com.example.transporte.models.services;

import com.example.transporte.models.dao.IEnvioDao;
import com.example.transporte.models.entity.Envio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class EnvioServiceImpl implements IEnvioService{

    @Autowired
    private IEnvioDao envioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Envio> findAll() {
        return (List<Envio>) envioDao.findAll();
    }

    @Override
    public Envio save(Envio envio) {
        return envioDao.save(envio);
    }

    @Override
    public void delete(Integer idEnvio) {
        envioDao.deleteById(idEnvio);
    }

    @Override
    public Optional<Envio> findByIdEnvio(Integer idEnvio) {
        return envioDao.findById(idEnvio);
    }
}
