package com.example.transporte.models.services;

import com.example.transporte.models.entity.TipoDocumento;

import java.util.List;

public interface ITipoDocumentoService {

    public List<TipoDocumento> findAll();

    public TipoDocumento findByIdTipoDocumento(Integer idTipoDocumento);
}
