package com.example.transporte.controller;

import com.example.transporte.models.entity.DetalleEnvio;
import com.example.transporte.models.services.IDetalleEnvioService;
import com.example.transporte.models.services.ITipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class DetalleEnvioController {

    @Autowired
    private IDetalleEnvioService detalleEnvioService;

    @Autowired
    private ITipoProductoService tipoProductoService;

    public List<DetalleEnvio> verDetalleEnvios(Integer idEnvio){
        detalleEnvioService.findByIdEnvio(idEnvio).forEach(detalleEnvio -> {
            detalleEnvio.setTipoProducto(tipoProductoService.findByIdTipoProducto(detalleEnvio.getIdTipoProducto()).get());
        });

        return detalleEnvioService.findByIdEnvio(idEnvio);
    }

    public ResponseEntity<String> guardarDetalleEnvio(List<DetalleEnvio> detalleEnvios) {
        ResponseEntity<String> responseEntity;

        if (!validacion(detalleEnvios)) {
            responseEntity = new ResponseEntity<String>("Error paramatros invalidos.",
                    HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            List<DetalleEnvio> detalleEnviosGuardado = (List<DetalleEnvio>) detalleEnvioService.saveAll(detalleEnvios);
            if (Objects.nonNull(detalleEnviosGuardado) && !detalleEnviosGuardado.isEmpty()) {
                responseEntity = new ResponseEntity<String>("El detalle del envio se guardo correctamente",
                        HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<String>("Error al guardar el detalle del envio",
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return responseEntity;
    }

    private boolean validacion(List<DetalleEnvio> detalleEnvios) {
        boolean validacion = true;
        if (Objects.isNull(detalleEnvios) || detalleEnvios.isEmpty()) {
            validacion = false;
        } else {
            for(DetalleEnvio detalleEnvio : detalleEnvios) {
                if (Objects.isNull(detalleEnvio.getIdTipoProducto())
                    || Objects.isNull(detalleEnvio.getIdEnvio())
                    || Objects.isNull(detalleEnvio.getIdTipoProducto())) {
                    validacion = false;
                    break;
                }
            }
        }

        return validacion;
    }

    public ResponseEntity<String> eliminar(Integer idEnvio) {
        ResponseEntity<String> responseEntity;

        try {
            detalleEnvioService.delete(idEnvio);
            responseEntity = new ResponseEntity<String>("El detalle envio se elimino correctamente",
                    HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>("Error al eliminar el detalle envio",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
