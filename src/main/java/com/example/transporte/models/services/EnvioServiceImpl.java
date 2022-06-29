package com.example.transporte.models.services;

import com.example.transporte.models.dao.IEnvioDao;
import com.example.transporte.models.entity.Envio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnvioServiceImpl implements IEnvioService{

    @Autowired
    private IEnvioDao envioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Envio> findAll() {
        return (List<Envio>) envioDao.findAll();
    }
}
