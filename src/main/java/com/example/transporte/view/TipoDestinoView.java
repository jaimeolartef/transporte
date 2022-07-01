package com.example.transporte.view;

import com.example.transporte.controller.TipoDestinoController;
import com.example.transporte.models.entity.TipoDestino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transporte")
public class TipoDestinoView {

    @Autowired
    private TipoDestinoController tipoDestinoController;

    @GetMapping("/tipo-destinos")
    public List<TipoDestino> tipoDestinos() {
        return tipoDestinoController.tipoDestinos();
    }
}
