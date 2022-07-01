package com.example.transporte.view;

import com.example.transporte.controller.TipoDocumentoController;
import com.example.transporte.models.entity.TipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/transporte")
public class TipoDocumentoView {

    @Autowired
    private TipoDocumentoController tipoDocumentoController;

    @GetMapping("/tipo-documentos")
    public List<TipoDocumento> tipoDocumentos() {
        return tipoDocumentoController.tipoDocumentos();
    }
}
