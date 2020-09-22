package edu.escuelaing.arep.server.model;

import java.util.Date;

public class Archivo {
    private String nombre;
    private Date fecha;

    public Archivo(String valor) {
        this.nombre = valor;
        fecha = new Date();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String valor) {
        this.nombre = valor;
    }
}
