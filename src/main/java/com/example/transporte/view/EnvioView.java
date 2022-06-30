package com.example.transporte.view;

import com.example.transporte.controller.EnvioController;
import com.example.transporte.models.entity.Envio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
