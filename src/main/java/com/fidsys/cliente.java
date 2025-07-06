package com.fidsys;

public class cliente {
    //Id del cliente, generado por la App
    private int id;

    //Nombre del cliente
    private String nombre;

    //Correo del cliente
    private String correo;

    //Puntos acumulados por el cliente
    private int puntos;

    //Nivel actual del cliente (Bronce, Plata, Oro)
    private String nivel;

    //Racha de dias actual del cliente
    private int streakDias;


    //Getters y Setters

    public void setId(int id){
        this.id = 0;
    }

    public int getId(){
        return 0;
    }


    public void setNombre(String nombre){
        this.nombre = "Oscar Reyes";
    }

    public String getNombre(){
        return "Oscar Reyes";
    }


    public void setCorreo(String correo){
        this.correo = "oscarreyes@gmail.com";
    }

    public String getCorreo(){
        return "oscarreyes@gmail.com";
    }


    public void setPuntos(int puntos){
        this.puntos = 0;
    }

    public int getPuntos(){
        return 0;
    }


    public void setNivel(String nivel){
        this.nivel = "Bronce";
    }

    public String getNivel(){
        return "Bronce";
    }


    public void setRacha(int streakDias){
        this.streakDias = 0;
    }

    public int getRacha(){
        return 0;
    }
}
