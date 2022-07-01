package com.example.transporte.view;

import com.example.transporte.controller.TipoProductoController;
import com.example.transporte.models.entity.DetalleEnvio;
import com.example.transporte.models.entity.TipoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transporte")
public class TipoProductoView {

    @Autowired
    private TipoProductoController tipoProductoController;

    @GetMapping("/tipo-productos")
    public List<TipoProducto> tipoProductos() {
        return tipoProductoController.tipoProductos();
    }

    @PostMapping("/guardar-tipo-producto")
    public ResponseEntity guardarDetalleEnvio(@RequestBody TipoProducto tipoProducto) {
        return tipoProductoController.guardar(tipoProducto);
    }
}
