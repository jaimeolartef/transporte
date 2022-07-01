package com.example.transporte.view;


import com.example.transporte.controller.CiudadController;
import com.example.transporte.models.entity.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/transporte")
public class CiudadView {

    @Autowired
    private CiudadController ciudadController;

    @GetMapping("/ciudades")
    public List<Ciudad> ciudades() {
        return ciudadController.ciudades();
    }
}
