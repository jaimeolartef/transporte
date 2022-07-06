package com.example.transporte.controller;

import com.example.transporte.models.entity.Cliente;
import com.example.transporte.models.services.IClienteService;
import com.example.transporte.models.services.ITipoDocumentoService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private ITipoDocumentoService tipoDocumentoService;

    public List<Cliente> clientes() {
        clienteService.findAll().forEach(cliente -> {
            cliente.setTipoDocumento(tipoDocumentoService.findByIdTipoDocumento(cliente.getIdTipoDocumento()));
        });
        return clienteService.findAll();
    }

    public ResponseEntity<String> guardar(Cliente cliente) {
        ResponseEntity<String> responseEntity;

        if (!validacion(cliente)) {
            responseEntity = new ResponseEntity<String>("Error paramatros invalidos.",
                    HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            Cliente clienteGuardado = clienteService.save(cliente);
            if (Objects.nonNull(clienteGuardado) && Objects.nonNull(clienteGuardado.getIdCliente())) {
                responseEntity = new ResponseEntity<String>("El cliente se guardo correctamente",
                        HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<String>("Error al guardar el cliente",
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return responseEntity;
    }

    private boolean validacion(Cliente cliente) {
        boolean validacion = true;
        if (Objects.isNull(cliente)) {
            validacion = false;
        } else if (Strings.isBlank(cliente.getDireccion())
                || Strings.isBlank(cliente.getNombre())
                || Strings.isBlank(cliente.getNumDocumento())
                || Strings.isBlank(cliente.getTelefono())
                || Objects.isNull(cliente.getIdTipoDocumento())) {
            validacion = false;
        }

        return validacion;
    }

    public ResponseEntity<String> eliminar(Integer idCliente) {
        ResponseEntity<String> responseEntity;

        try {
            clienteService.delete(idCliente);
            responseEntity = new ResponseEntity<String>("El cliente se elimino correctamente",
                    HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>("Error al eliminar el cliente",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
