package com.example.transporte.controller;

import com.example.transporte.models.entity.Destino;
import com.example.transporte.models.services.IDestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Objects;
@Controller
public class DestinoController {
    @Autowired
    private IDestinoService destinoService;

    public ResponseEntity guardar(Destino destino) {
        ResponseEntity responseEntity;
        Destino destinoGuardado = destinoService.guardar(destino);
        if (Objects.nonNull(destinoGuardado) && Objects.nonNull(destinoGuardado.getIdDestino())) {
            responseEntity = new ResponseEntity<>("El destino se guardo correctamente",
                    HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("Error al guardar el destino",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
