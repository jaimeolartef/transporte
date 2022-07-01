package com.example.transporte.controller;

import com.example.transporte.models.entity.Ciudad;
import com.example.transporte.models.services.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CiudadController {

    @Autowired
    private ICiudadService ciudadService;

    public List<Ciudad> ciudades() {
        return ciudadService.findAll();
    }

}
