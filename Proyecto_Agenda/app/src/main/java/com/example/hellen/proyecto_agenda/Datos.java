package com.example.hellen.proyecto_agenda;

/**
 * Created by A on 01/05/2015.
 */
public class Datos {

    private int Id_Datos;
    private String Titulo;
    private int Hora;
    private String Lugar;
    private String Descripcion;

    public Datos() {
        //Constructor Vacio
    }

    public Datos(String titulo, int hora, String lugar, String descripcion) {
        this.Titulo = titulo;
        this.Hora = hora;
        this.Lugar = lugar;
        this.Descripcion = descripcion;
    }

    public int get_Id_Datos() {
        return Id_Datos;
    }

    public void set_id(int Id_Datos) {
        this.Id_Datos = Id_Datos;
    }

    public String get_Titulo() {
        return Titulo;
    }

    public void set_Titulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String get_Lugar() {
        return Lugar;
    }

    public void set_Lugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public int get_Hora() {
        return Hora;
    }

    public void set_Hora(int Hora) {
        this.Hora = Hora;
    }

    public String get_Descripcion() {
        return Descripcion;
    }

    public void set_Descripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
}


