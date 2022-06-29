package com.example.transporte.view;

import com.example.transporte.controller.EnvioController;
import com.example.transporte.models.entity.Envio;
import com.example.transporte.models.services.IEnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transporte")
public class EnvioView {

    @Autowired
    private EnvioController envioController;

    @GetMapping("/envios")
    public List<Envio> envios() {
        return envioController.envios();
    }


}
