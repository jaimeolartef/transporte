package com.example.transporte.controller;

import com.example.transporte.models.entity.Ciudad;
import com.example.transporte.models.entity.Cliente;
import com.example.transporte.models.entity.Destino;
import com.example.transporte.models.entity.TipoDestino;
import com.example.transporte.models.services.ICiudadService;
import com.example.transporte.models.services.IDestinoService;
import com.example.transporte.models.services.ITipoDestinoService;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class DestinoControllerTest {

    @Mock
    private IDestinoService destinoService;

    @Mock
    private ITipoDestinoService tipoDestinoService;

    @Mock
    private ICiudadService ciudadService;

    @InjectMocks
    private DestinoController destinoController;

    private Destino destino;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        destino = new Destino();
        destino.setIdDestino(1);
        destino.setIdTipoDestino(1);
        destino.setNombre("Prueba");
        destino.setDireccion("Prueba");
        destino.setIdCiudad(1);
    }

    @Test
    void whenFindAllDestinosThenListDestino() {
        when(destinoService.findAll()).thenReturn(Arrays.asList(destino));
        when(tipoDestinoService.findByIdTipoDestino(anyInt())).thenReturn(new TipoDestino());
        when(ciudadService.findByIdCiudad(destino.getIdCiudad())).thenReturn(new Ciudad());
        assertNotNull(destinoController.destinos());
    }

    @Test
    void givenDestinoWhenGuardarThenResponseHttpOk() {
        when(destinoService.save(any(Destino.class))).thenReturn(destino);
        assertEquals(destinoController.guardar(destino), new ResponseEntity<String>("El destino se guardo correctamente",
                HttpStatus.OK));
    }

    @Test
    public void givenDestinoWhenGuardarThenResponseHttpUnprocessableEntity() {
        destino.setNombre(Strings.EMPTY);
        when(destinoService.save(destino)).thenReturn(destino);
        assertEquals(destinoController.guardar(destino), new ResponseEntity<String>("Error paramatros invalidos.",
                HttpStatus.UNPROCESSABLE_ENTITY));
    }

    @Test
    void givenIdDestinoWhenEliminarThenVoid() {
        destinoService.delete(anyInt());
        assertEquals(destinoController.eliminar(anyInt()), new ResponseEntity<String>("El destino se elimino correctamente",
                HttpStatus.OK));
    }
}