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


    //Sube de puntos al cliente
    public void addPuntos(int puntos){
        int puntosActuales = this.getPuntos();

        int puntosNuevos = puntosActuales + puntos;

        this.setPuntos(puntosNuevos);

        verificarNivel();
    }


    //Sube de nivel al cliente si tiene los puntos necesarios
    private void verificarNivel(){
        int puntosActuales = this.getPuntos();

        if(puntosActuales >= 500 && puntosActuales < 1500){
            this.setNivel("Plata");
        }

        else if(puntosActuales >= 1500 && puntosActuales < 3000){
            this.setNivel("Oro");
        }

        else if(puntosActuales >= 3000){
            this.setNivel("Platino");
        }

        else{
            this.setNivel("Bronce");
        }
    }
}
