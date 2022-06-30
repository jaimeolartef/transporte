package com.example.transporte.view;

import com.example.transporte.controller.DestinoController;
import com.example.transporte.models.entity.Destino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transportadora")
public class DestinoView {

    @Autowired
    private DestinoController destinoController;

    @PostMapping("/guardar-destino")
    public ResponseEntity guardar(@RequestBody Destino destino) {
        return destinoController.guardar(destino);
    }
}
