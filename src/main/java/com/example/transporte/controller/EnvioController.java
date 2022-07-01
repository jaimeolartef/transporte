package com.example.transporte.controller;

import com.example.transporte.models.entity.Cliente;
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
import java.util.stream.Collectors;

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

    public ResponseEntity guardar(Envio envio) {
        ResponseEntity responseEntity;

        if (!validacion(envio)) {
            responseEntity = new ResponseEntity<>("Error paramatros invalidos.",
                    HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            Envio envioGuardado = envioService.save(envio);
            if (Objects.nonNull(envioGuardado) && Objects.nonNull(envioGuardado.getIdEnvio())) {
                responseEntity = new ResponseEntity<>("El envio se guardo correctamente",
                        HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>("Error al guardar el destino",
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

}
