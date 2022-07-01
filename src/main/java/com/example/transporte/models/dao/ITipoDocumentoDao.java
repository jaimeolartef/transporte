package com.example.transporte.models.dao;

import com.example.transporte.models.entity.TipoDocumento;
import org.springframework.data.repository.CrudRepository;

public interface ITipoDocumentoDao extends CrudRepository<TipoDocumento, Integer> {
}
