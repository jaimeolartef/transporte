package com.example.transporte.view;

import com.example.transporte.controller.DestinoController;
import com.example.transporte.models.entity.Destino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("/transportadora")
public class DestinoView {

    @Autowired
    private DestinoController destinoController;

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/guardar-destino")
    public ResponseEntity guardar(@RequestBody Destino destino) {
        return destinoController.guardar(destino);
    }
}
