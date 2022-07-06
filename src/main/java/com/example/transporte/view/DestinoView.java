package com.example.transporte.view;

import com.example.transporte.controller.DestinoController;
import com.example.transporte.models.entity.Destino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transporte")
public class DestinoView {

    @Autowired
    private DestinoController destinoController;

    @GetMapping("/destinos")
    public List<Destino> destinos() {
        return destinoController.destinos();
    }

    @PostMapping("/guardar-destino")
    public ResponseEntity<String> guardar(@RequestBody Destino destino) {
        return destinoController.guardar(destino);
    }

    @DeleteMapping("/eliminar-destino/{id}")
    public ResponseEntity<String> eliminarDestino(@PathVariable(value = "id") Integer idDestino) {
        return destinoController.eliminar(idDestino);
    }
}
