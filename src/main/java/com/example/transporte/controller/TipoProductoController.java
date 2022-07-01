package com.example.transporte.controller;

import com.example.transporte.models.entity.TipoProducto;
import com.example.transporte.models.services.ITipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class TipoProductoController {

    @Autowired
    private ITipoProductoService tipoProductoService;

    public List<TipoProducto> tipoProductos() {
        return tipoProductoService.findAll();
    }

    public ResponseEntity guardar(TipoProducto tipoProducto) {
        ResponseEntity responseEntity;

        TipoProducto tipoProductoGuardado = tipoProductoService.save(tipoProducto);

        if (Objects.nonNull(tipoProductoGuardado) && Objects.nonNull(tipoProductoGuardado.getIdTipoProducto())) {
            responseEntity = new ResponseEntity<>("El envio se guardo correctamente",
                    HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("Error al guardar el destino",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
