package com.example.transporte.controller;

import com.example.transporte.models.entity.TipoDestino;
import com.example.transporte.models.services.ITipoDestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TipoDestinoController {

    @Autowired
    private ITipoDestinoService tipoDestinoService;

    public List<TipoDestino> tipoDestinos() {
        return tipoDestinoService.findAll();
    }
}
