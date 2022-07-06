package com.example.transporte.view;

import com.example.transporte.controller.EnvioController;
import com.example.transporte.models.entity.Envio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/guardar-envio")
    public ResponseEntity<String> guardar(@RequestBody Envio envio) {
        return envioController.guardar(envio);
    }

    @DeleteMapping("/eliminar-envio/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable(value = "id") Integer idEnvio) {
        return envioController.eliminar(idEnvio);
    }
}
