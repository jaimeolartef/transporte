package com.example.transporte.controller;

import com.example.transporte.models.entity.TipoDocumento;
import com.example.transporte.models.services.ITipoDocumentoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TipoDocumentoControllerTest {

    @Mock
    private ITipoDocumentoService tipoDocumentoService;

    @InjectMocks
    private TipoDocumentoController tipoDocumentoController;

    private TipoDocumento tipoDocumento;
    private List<TipoDocumento> tipoDocumentos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tipoDocumento = new TipoDocumento();
        tipoDocumento.setIdTipoDocumento(1);
        tipoDocumento.setNombre("ABC111");
        tipoDocumentos = new ArrayList<>();
        tipoDocumentos.add(tipoDocumento);
    }

    @Test
    void whenFindAllTipoDocumentoThenTipoDocumentos() {
        Mockito.when(tipoDocumentoService.findAll()).thenReturn(tipoDocumentos);
        assertNotNull(tipoDocumentoController.tipoDocumentos());
    }
}