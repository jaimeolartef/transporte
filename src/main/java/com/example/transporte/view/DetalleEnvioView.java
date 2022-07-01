package com.example.transporte.view;

import com.example.transporte.controller.DetalleEnvioController;
import com.example.transporte.models.entity.DetalleEnvio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transporte")
public class DetalleEnvioView {

    @Autowired
    private DetalleEnvioController detalleEnvioController;

    @GetMapping("/ver-detalle-envio/{idEnvio}")
    public List<DetalleEnvio> verDetalleEnvios(@PathVariable(value = "idEnvio") Integer idEnvio) {
        return detalleEnvioController.verDetalleEnvios(idEnvio);
    }

    @PostMapping("/guardar-detalle-envio")
    public ResponseEntity guardarDetalleEnvio(@RequestBody List<DetalleEnvio> detalleEnvios) {
        return detalleEnvioController.guardarDetalleEnvio(detalleEnvios);
    }
}
