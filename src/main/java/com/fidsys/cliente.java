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
        this.id = id;
    }

    public int getId(){
        return this.id;
    }


    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }


    public void setCorreo(String correo){
        if(correo.contains("@")){
            this.correo = correo;
        }
    }

    public String getCorreo(){
        return this.correo;
    }


    public void setPuntos(int puntos){
        this.puntos = puntos;
    }

    public int getPuntos(){
        return this.puntos;
    }


    public void setNivel(String nivel){
        this.nivel = nivel;
    }

    public String getNivel(){
        return this.nivel;
    }


    public void setRacha(int streakDias){
        this.streakDias = streakDias;
    }

    public int getRacha(){
        return this.streakDias;
    }


    //Sube de nivel al cliente
    public void addPuntos(int puntos){
        int puntosActuales = this.getPuntos();

        int puntosNuevos = puntosActuales + puntos;

        this.setPuntos(puntosNuevos);
    }
}
