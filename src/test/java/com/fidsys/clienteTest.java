package com.fidsys;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class clienteTest{

    private cliente cliente;

    @Test
    public void crear_Cliente(){
        //Given
        cliente = new cliente();

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
        assertEquals(id, cliente.getId(), "El id dado ha sido correcto");
        assertEquals(nombre, cliente.getNombre());
        assertEquals(correo, cliente.getCorreo());
        assertEquals(0, cliente.getPuntos());
        assertEquals("Bronce", cliente.getNivel());
        assertEquals(0, cliente.getRacha());
    }
}