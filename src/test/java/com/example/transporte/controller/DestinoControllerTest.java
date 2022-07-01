package com.example.transporte.controller;


import com.example.transporte.models.entity.Destino;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = DestinoController.class
)*/
public class DestinoControllerTest {

    @Autowired
    private DestinoController destinoController;

    //@Test
    public void guardar() {

        Destino destino = new Destino();
        destino.setIdTipoDestino(1);
        destino.setDireccion("Calle prueba 1");
        destino.setNombre("Destino de prueba test");
        destino.setIdCiudad(1);

        Assert.isTrue(destinoController.guardar(destino).getStatusCode().equals(HttpStatus.OK), "");
    }
}
