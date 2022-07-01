package com.example.transporte.controller;

import com.example.transporte.models.entity.TipoDocumento;
import com.example.transporte.models.services.ITipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TipoDocumentoController {

    @Autowired
    private ITipoDocumentoService tipoDocumentoService;

    public List<TipoDocumento> tipoDocumentos() {
        return tipoDocumentoService.findAll();
    }
}
