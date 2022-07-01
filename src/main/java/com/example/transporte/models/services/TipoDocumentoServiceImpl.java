package com.example.transporte.models.services;

import com.example.transporte.models.dao.ITipoDocumentoDao;
import com.example.transporte.models.entity.TipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService {

    @Autowired
    private ITipoDocumentoDao tipoDocumentoDao;

    @Override
    public List<TipoDocumento> findAll() {
        return (List<TipoDocumento>) tipoDocumentoDao.findAll();
    }

    @Override
    public TipoDocumento findByIdTipoDocumento(Integer idTipoDocumento) {
        return tipoDocumentoDao.findById(idTipoDocumento).get();
    }
}
