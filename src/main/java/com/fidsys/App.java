package com.fidsys;

import java.io.Console;
import java.time.LocalDate;
import java.util.ArrayList;

public class App{

    private static ArrayList<cliente> lista_clientes = new ArrayList<cliente>();
    private static ArrayList<compra> lista_compras = new ArrayList<compra>();

    private static int lastIdCliente = 1;
    private static int lastIdCompra = 1;
    public static void main(String[] args){
        Boolean menu = false;

        Console console = System.console();

        while(menu){
            String resp = console.readLine("Bienvenido al menu, estas son los modulos que se pueden utilizar: \n 1- Modulo de clientes \n 2- Modulo de compras \n 3- Buscar puntos y nivel de un cliente \n 4- Cerrar menu \n Opcion:");

            if(resp.equals("1")){
                String respCliente = console.readLine("Las opciones del modulo de clientes son: \n 1- Crear un cliente \n 2- Listar clientes actuales \n 3- Modificar la informacion de un cliente \n 4- Eliminar un cliente \n Opcion:");

                String mensaje = moduloCliente(respCliente);

                System.out.println(mensaje);
            }

            else if(resp.equals("2")){
                String respCompra = console.readLine("Las opciones del modulo de compras son: \n 1- Crear nueva compra \n 2- Listar todas las compras \n 3- Modificar la informacion de una compra \n 4- Eliminar una compra \n Opcion:");
            
                String mensaje = moduloCompras(respCompra);

                System.out.println(mensaje);
            }

            else if(resp.equals("3")){
                String nombre = console.readLine("Escribe el nombre del cliente al que se quiere mostrar puntos y nivel: ");

                for(cliente cliente: lista_clientes){
                    if(cliente.getNombre().equals(nombre)){
                        System.out.println("Nombre cliente: " + nombre + ", Puntos: " + cliente.getPuntos() + ", Nivel: " + cliente.getNivel());
                    }
                }
            }
            
            else if(resp.equals("4")){
                menu = false;
                System.out.println("Cerrando la aplicación");
            }

            else{
                System.out.println("No se ha seleccionado una opción valida");
            }
        }
    }

    //Modulo de clientes que se puede testear
    public static String moduloCliente(String opcion){
        Console console = System.console();

        if(opcion.equals("1")){
            cliente nuevo_cliente = new cliente();

            String nombre= console.readLine("Cual es el nombre del nuevo cliente: ");

            nuevo_cliente.setNombre(nombre);

            String correo= console.readLine("Cual es el correo del nuevo cliente: ");

            nuevo_cliente.setCorreo(correo);

            nuevo_cliente.setId(lastIdCliente);
            lastIdCliente = lastIdCliente + 1;

            nuevo_cliente.setPuntos(0);
            nuevo_cliente.setNivel("Bronce");

            lista_clientes.add(nuevo_cliente);

            return("Se ha creado el nuevo cliente: " + nuevo_cliente.getNombre() + ", cuyo Id es:" + nuevo_cliente.getId() + "\n");
        }
        
        else if(opcion.equals("2")){
            String mensaje_lista = "";
            for(cliente cliente: lista_clientes){
                mensaje_lista= mensaje_lista + "(Nombre: " + cliente.getNombre() + ", Id: " + cliente.getId() + ", correo: " + cliente.getCorreo() + ", puntos: " + cliente.getPuntos() + ", nivel: " + cliente.getNivel() + ") \n";
            }

            return mensaje_lista;
        }

        else if(opcion.equals("3")){
            String nombre = console.readLine("Escribe el nombre del cliente que se quiere modificar: ");

            for(cliente cliente: lista_clientes){
                if(cliente.getNombre().equals(nombre)){
                    System.out.println("Informacio actual: Nombre: " + cliente.getNombre() + ", Correo: " + cliente.getCorreo());

                    String nombre_nuevo= console.readLine("Cual es el nuevo nombre del cliente: ");
                    cliente.setNombre(nombre_nuevo);

                    String correo_nuevo= console.readLine("Cual es el nuevo correo del cliente: ");
                    cliente.setCorreo(correo_nuevo);
                }
            }

            return "Se ha modificado el cliente";
        }
        
        else if(opcion.equals("4")){
            String nombre = console.readLine("Escribe el nombre del cliente que se quiere eliminar: ");

            cliente cliente_eliminar = new cliente();

            for(cliente cliente: lista_clientes){
                if(cliente.getNombre().equals(nombre)){
                    cliente_eliminar = cliente;
                }
            }


            try{
                lista_clientes.remove(cliente_eliminar);
                return "Se ha eliminado el cliente correctamente";
            }
            catch(Exception error){
                System.out.println("Ha ocurrido el siguiente error: " + error);
                return "Error: " + error;
            }
        }

        else{
            return "No se ha seleccionado una opción correcta, solo es de 1 a 4. \n";
        }
    }

    //Modulo de compras que se puede testear
    public static String moduloCompras(String opcion){
        Console console = System.console();

        if(opcion.equals("1")){
            compra nueva_compra = new compra();

            String monto_Resp = console.readLine("Cual es el monto de la nueva compra: ");
            Double monto = Double.parseDouble(monto_Resp);

            nueva_compra.setMonto(monto);

            String cliente_compra= console.readLine("Cual es el cliente de la nueva compra: ");

            try{
                int id_cliente = 0;

                for(cliente cliente: lista_clientes){
                    if(cliente.getNombre().equals(cliente_compra)){
                        id_cliente = cliente.getId();
                        int puntos_agregar = 0;

                        if(cliente.getNivel().equals("Plata")){
                            Double calculo = ((monto.intValue() / 10) * 1.2);
                            puntos_agregar = puntos_agregar + calculo.intValue();
                        }

                        if(cliente.getNivel().equals("Oro")){
                            Double calculo = ((monto.intValue() / 10) * 1.5);
                            puntos_agregar = puntos_agregar + calculo.intValue();
                        }

                        if(cliente.getNivel().equals("Platino")){
                            int calculo = ((monto.intValue() / 10) * 2);
                            puntos_agregar = puntos_agregar + calculo;
                        }

                        else{
                            int calculo = (monto.intValue() / 10);
                            puntos_agregar = puntos_agregar + calculo;
                        }

                        cliente.addPuntos(puntos_agregar);
                    }
                }

                nueva_compra.setIdCliente(id_cliente);
            }
            catch(Error error){
                return "Ha ocurrido un error: " + error;
            }

            nueva_compra.setIdCompra(lastIdCompra);
            lastIdCompra = lastIdCompra + 1;

            nueva_compra.setFecha(LocalDate.now());
            lista_compras.add(nueva_compra);

            return("Se ha creado la nueva compra: cuyo ID es " + nueva_compra.getIdCompra() + "y el ID del cliente es:" + nueva_compra.getIdCompra() + "\n");
        }
        
        else if(opcion.equals("2")){
            String mensaje_lista = "";
            for(compra compra: lista_compras){
                mensaje_lista= mensaje_lista + "(Id compra: " + compra.getIdCompra() + ", Id cliente: " + compra.getIdCliente() + ", monto: " + compra.getMonto() + ", fecha: " + compra.getFecha() + ") \n";
            }

            return mensaje_lista;
        }

        else if(opcion.equals("3")){
            String id = console.readLine("Escribe el id de la compra que se quiere modificar: ");
            int id_int = Integer.parseInt(id);

            for(compra compra: lista_compras){
                if(compra.getIdCompra() == id_int){
                    System.out.println("Informacio actual: Monto: " + compra.getMonto());

                    String monto_nuevo= console.readLine("Cual es el nuevo monto de la compra: ");
                    compra.setMonto(Double.parseDouble(monto_nuevo));
                }
            }

            return "Se ha modificado el monto de la compra";
        }
        
        else if(opcion.equals("4")){
            String id_compra = console.readLine("Escribe el ID de la compra que se quiere eliminar: ");
            int id= Integer.parseInt(id_compra);

            compra compra_eliminar = new compra();

            for(compra compra: lista_compras){
                if(compra.getIdCompra() == id){
                    compra_eliminar = compra;
                }
            }

            try{
                lista_compras.remove(compra_eliminar);
                return "Se ha eliminado la compra correctamente";
            }
            catch(Exception error){
                System.out.println("Ha ocurrido el siguiente error: " + error);
                return "Error: " + error;
            }
        }

        else{
            return "No se ha seleccionado una opción correcta, solo es de 1 a 4. \n";
        }
    }
}