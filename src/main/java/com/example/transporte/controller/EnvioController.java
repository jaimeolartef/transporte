package com.example.transporte.controller;

import com.example.transporte.models.entity.Envio;
import com.example.transporte.models.services.IEnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EnvioController {

    @Autowired
    private IEnvioService envioService;

    public List<Envio> envios() {
        return envioService.findAll();
    }

}
