package com.example.transporte.view;


import com.example.transporte.controller.ClienteController;
import com.example.transporte.models.entity.Cliente;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/transporte")
public class ClienteView {

    @Autowired
    private ClienteController clienteController;

    @GetMapping("/clientes")
    public List<Cliente> clientes() {
        return clienteController.clientes();
    }

    @PostMapping("/guardar-cliente")
    public ResponseEntity guardar(@RequestBody Cliente cliente) {
        return clienteController.guardar(cliente);
    }

}
