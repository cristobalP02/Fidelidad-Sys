package com.fidsys;

import java.time.LocalDate;

public class compra {
    //Id de la compra asociado
    private int idCompra;

    //Id del cliente que realizo la compra
    private int idCliente;

    //Monto total de la compra (precio acumulado de los productos)
    private Double monto;

    //Fecha de la compra
    private LocalDate fecha;


    //Setters y Getters
    public int getIdCompra(){
        return this.idCompra;
    }

    public void setIdCompra(int idCompra){
        this.idCompra = idCompra;
    }

    public int getIdCliente(){
        return this.idCliente;
    }

    public void setIdCliente(int idCliente){
        this.idCliente = idCliente;
    }

    public Double getMonto(){
        return this.monto;
    }

    public void setMonto(Double monto){
        this.monto = monto;
    }

    public LocalDate getFecha(){
        return this.fecha;
    }

    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }
}
