package com.example.transporte.view;

import com.example.transporte.controller.DestinoController;
import com.example.transporte.models.entity.Destino;
import com.example.transporte.models.services.IDestinoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DestinoViewTest {

    @Mock
    private DestinoController destinoController;

    @Mock
    private IDestinoService destinoService;

    @InjectMocks
    private DestinoView destinoView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenDestinoWhenGuardarThenResponseHttpOk() {
        Destino destino = new Destino();
        destino.setIdTipoDestino(1);
        destino.setNombre("Prueba");
        destino.setDireccion("Prueba");
        destino.setIdCiudad(1);
        when(destinoService.save(destino)).thenReturn(destino);
        when(destinoController.guardar(destino)).thenReturn(new ResponseEntity<String>("El destino se guardo correctamente",
                HttpStatus.OK));
        when(destinoView.guardar(destino)).thenReturn(new ResponseEntity<String>("El destino se guardo correctamente",
                HttpStatus.OK));
        assertNotNull(destinoService.save(destino));
        assertNotNull(destinoController.guardar(destino));
        assertNotNull(destinoView.guardar(destino));
    }
}