package com.example.transporte.controller;

import com.example.transporte.models.entity.Destino;
import com.example.transporte.models.services.ICiudadService;
import com.example.transporte.models.services.IDestinoService;
import com.example.transporte.models.services.ITipoDestinoService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class DestinoController {
    @Autowired
    private IDestinoService destinoService;

    @Autowired
    private ITipoDestinoService tipoDestinoService;

    @Autowired
    private ICiudadService ciudadService;

    public List<Destino> destinos() {
        List<Destino> destinos =  destinoService.findAll();

        destinos.forEach(destino -> {
            destino.setTipoDestino(tipoDestinoService.findByIdTipoDestino(destino.getIdTipoDestino()));
            destino.setCiudad(ciudadService.findByIdCiudad(destino.getIdCiudad()));
        });
        return destinos;
    }

    public ResponseEntity<String> guardar(Destino destino) {
        ResponseEntity responseEntity;

        if (!validacion(destino)) {
            responseEntity = new ResponseEntity<String>("Error paramatros invalidos.",
                    HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            Destino destinoGuardado = destinoService.save(destino);
            if (Objects.nonNull(destinoGuardado) && Objects.nonNull(destinoGuardado.getIdDestino())) {
                responseEntity = new ResponseEntity<String>("El destino se guardo correctamente",
                        HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<String>("Error al guardar el destino",
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return responseEntity;
    }

    private boolean validacion(Destino destino) {
        boolean validacion = true;
        if (Objects.isNull(destino)) {
            validacion = false;
        } else if (Strings.isBlank(destino.getDireccion())
                    || Strings.isBlank(destino.getNombre())
                    || Objects.isNull(destino.getIdTipoDestino())
                    || Objects.isNull(destino.getIdCiudad())) {
            validacion = false;
        }

        return validacion;
    }

    public ResponseEntity<String> eliminar(Integer idDestino) {
        ResponseEntity<String> responseEntity;

        try {
            destinoService.delete(idDestino);
            responseEntity = new ResponseEntity<String>("El destino se elimino correctamente",
                    HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>("Error al eliminar el destino",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
