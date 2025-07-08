package com.fidsys;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class clienteTest{

    private cliente cliente;

    @BeforeEach
    public void setUp() throws Exception{
        cliente = new cliente();
    }

    @Test
    public void crear_Cliente() throws Exception{
        //Given
        int id = 9999;
        String nombre = "Cristobal Perez";
        String correo = "cristobal.perezb@usm.cl";


        //When
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setCorreo(correo);
        cliente.setPuntos(0);
        cliente.setNivel("Bronce");
        cliente.setRacha(0);

        //Then
        assertEquals(id, cliente.getId());
        assertEquals(nombre, cliente.getNombre());
        assertEquals(correo, cliente.getCorreo());
        assertEquals(0, cliente.getPuntos());
        assertEquals("Bronce", cliente.getNivel());
        assertEquals(0, cliente.getRacha());
    }


    @Test
    public void correoErroneo() throws Exception{
        //Given
        String correo = "cristobal.gmail.cl";

        //When
        cliente.setCorreo(correo);

        //Then
        assertEquals(null, cliente.getCorreo(), "El resultado ha sido erroneo, ha asignado el correo, pese a que no tiene @");
    }


    @Test
    public void subirNivelPlata() throws Exception{
        //Given
        cliente.setPuntos(0);
        cliente.setNivel("Bronce");
        
        //When
        cliente.addPuntos(500);

        //Then
        assertEquals("Plata", cliente.getNivel(), "No subio de nivel a Plata, pero debería");
    }


    /*
     * @Test
    public void correoErroneo(){
        //Given
        //When
        //Then
    }

    
     */
}