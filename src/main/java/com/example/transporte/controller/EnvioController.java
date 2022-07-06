package com.example.transporte.controller;

import com.example.transporte.models.entity.Envio;
import com.example.transporte.models.services.IClienteService;
import com.example.transporte.models.services.IDestinoService;
import com.example.transporte.models.services.IEnvioService;
import com.example.transporte.models.services.IVehiculoService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class EnvioController {

    @Autowired
    private IEnvioService envioService;

    @Autowired
    private IDestinoService destinoService;

    @Autowired
    private IVehiculoService vehiculoService;

    @Autowired
    private IClienteService clienteService;

    public List<Envio> envios() {
        envioService.findAll().forEach(envio -> {
            envio.setDestino(destinoService.findByIdDestino(envio.getIdDestino()));
            envio.setCliente(clienteService.findByIdCliente(envio.getIdCliente()));
            envio.setVehiculo(vehiculoService.findById(envio.getIdVehiculo()));
        });

        return envioService.findAll();
    }

    public ResponseEntity<String> guardar(Envio envio) {
        ResponseEntity<String> responseEntity;

        if (!validacion(envio)) {
            responseEntity = new ResponseEntity<String>("Error paramatros invalidos.",
                    HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            Envio envioGuardado = envioService.save(envio);
            if (Objects.nonNull(envioGuardado) && Objects.nonNull(envioGuardado.getIdEnvio())) {
                responseEntity = new ResponseEntity<String>("El envio se guardo correctamente",
                        HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<String>("Error al guardar el destino",
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return responseEntity;
    }


    private boolean validacion(Envio envio) {
        boolean validacion = true;
        if (Objects.isNull(envio)) {
            validacion = false;
        } else if (Strings.isBlank(envio.getNumGuia())
                || Objects.isNull(envio.getIdCliente())
                || Objects.isNull(envio.getIdVehiculo())
                || Objects.isNull(envio.getFechaEntrega())
                || Objects.isNull(envio.getSubtotal())
                || Objects.isNull(envio.getDescuento())
                || Objects.isNull(envio.getTotal())
                || Objects.isNull(envio.getIdDestino())) {
            validacion = false;
        }

        return validacion;
    }

    public ResponseEntity<String> eliminar(Integer idEnvio) {
        ResponseEntity<String> responseEntity;

        try {
            envioService.delete(idEnvio);
            responseEntity = new ResponseEntity<String>("El detalle envio se elimino correctamente",
                    HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>("Error al eliminar el detalle envio",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

}
